package com.estiven.dev.logincompose.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.facebook.AccessToken
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private var auth: FirebaseAuth = FirebaseAuth.getInstance()
    private var _message = MutableLiveData("")
    private var _loading = MutableLiveData<Boolean>()
    var message: LiveData<String> = _message
    var loading: LiveData<Boolean> = _loading

    fun signUpWithEmail(
        fullName: String,
        email: String,
        password: String,
        firebaseViewModel: FirebaseViewModel
    ) {
        viewModelScope.launch {
            _loading.value = true
            if (email.isEmpty() && password.isEmpty() || fullName.isEmpty()) {
                _message.value = "Hay campos vacios"
                _loading.value = false
            } else {
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            _loading.value = false
                            _message.value = "Se ha registrado correctamente"
                            firebaseViewModel.saveUser(fullName, email)
                        } else {
                            _loading.value = false
                            _message.value = it.exception?.message
                        }
                    }
                    .addOnFailureListener {
                        _loading.value = false
                        _message.value = it.message
                    }
            }
        }
    }

    fun signUpWithGoogle(
        token: String,
        firebaseViewModel: FirebaseViewModel
    ) {
        viewModelScope.launch {
            _loading.value = true
            val credentials = GoogleAuthProvider.getCredential(token, null)
            auth.signInWithCredential(credentials)
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        _loading.value = false
                        val user = it.result.user
                        firebaseViewModel.saveUserGoogle(
                            user?.displayName!!,
                            user.email!!,
                            user.photoUrl!!
                        )
                        Log.d("cambio", user.photoUrl!!.toString())
                    }
                }
                .addOnFailureListener {
                    _loading.value = false
                    Log.d("etiqueta", it.message!!)
                }
        }
    }

    fun signUpWithFacebook(token: AccessToken) {
        val credentials = FacebookAuthProvider.getCredential(token.token)
        viewModelScope.launch {
            _loading.value = true
            auth.signInWithCredential(credentials)
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        _message.value = "Success"
                        _loading.value = false
                    } else {
                        _message.value = it.exception?.message
                        _loading.value = false
                    }
                }
                .addOnFailureListener {
                    _message.value = it.message
                    _loading.value = false
                }
        }
    }
}