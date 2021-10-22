package com.estiven.dev.logincompose.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ExitToApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

class HomeActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Column(

            ) {
                CustomButton(
                    icon = Icons.Outlined.ExitToApp,
                    text = "CERRAR SESIÓN",
                    loading = false,
                    active = true
                ) {
                   FirebaseAuth.getInstance().signOut()
                }
            }
        }
    }
}