package com.estiven.dev.logincompose.ui.viewmodel

import android.net.Uri
import android.util.Log
import androidx.lifecycle.ViewModel
import com.estiven.dev.logincompose.data.model.User
import com.estiven.dev.logincompose.data.model.UserGoogle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class FirebaseViewModel : ViewModel() {

    private val db = Firebase.firestore
    private val auth = FirebaseAuth.getInstance()

    private fun getId(): String {
        var uid = ""
        val currentUser = auth.currentUser
        if (currentUser != null) {
            uid = currentUser.uid
        }
        return uid
    }

    fun saveUserGoogle(
        fullName: String,
        email: String,
        photoUrl: Uri
    ) {
        val data = UserGoogle(
            fullName, email, photoUrl.path!!
        )
        db.collection("users")
            .document(getId())
            .set(data)
            .addOnCompleteListener {
                Log.d("loginFacebook", "success")
            }
            .addOnFailureListener {
                Log.d("loginFacebook", it.message!!)
            }
    }


    fun saveUser(fullName: String, email: String) {
        val data = User(
            fullName,
            email,
        )
        db.collection("users")
            .document(getId())
            .set(data)
            .addOnCompleteListener {
                it.exception?.message?.let { it1 ->
                    Log.d("user", it1)
                }
            }.addOnFailureListener {
                it.message?.let { it1 ->
                    Log.d("user", it1)
                }
            }
    }
}