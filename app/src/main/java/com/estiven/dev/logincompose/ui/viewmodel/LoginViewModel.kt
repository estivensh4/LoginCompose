package com.estiven.dev.logincompose.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private var auth: FirebaseAuth = FirebaseAuth.getInstance()
    private var _message = MutableLiveData("")
    private var _loading = MutableLiveData<Boolean>()

    fun signUp(
        fullName: String,
        email: String,
        password: String
    ) {
        viewModelScope.launch {
            _loading.value = true
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        _loading.value = false
                        _message.value = "Se ha registrado correctamente"

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