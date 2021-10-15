package com.estiven.dev.logincompose.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.estiven.dev.logincompose.data.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class FirebaseViewModel : ViewModel() {
    private val database = Firebase.database
    private val auth = FirebaseAuth.getInstance()
    private val ref = database.reference

    private fun getId(): String {
        var uid = ""
        val currentUser = auth.currentUser
        if (currentUser != null) {
            uid = currentUser.uid
        }
        return uid
    }

    fun saveUser(fullName: String, email: String, password: String) {
        val data = User(
            fullName,
            email,
            password
        )
        ref.child("Users").child(getId()).setValue(data)
    }
}