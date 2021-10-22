package com.estiven.dev.logincompose.ui.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.rememberNavController
import com.estiven.dev.logincompose.ui.theme.LoginComposeTheme
import com.estiven.dev.logincompose.ui.view.navigation.NavigationHost
import com.estiven.dev.logincompose.ui.viewmodel.FirebaseViewModel
import com.estiven.dev.logincompose.ui.viewmodel.LoginViewModel
import com.facebook.FacebookSdk
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.Identity
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.firebase.auth.FirebaseAuth

class MainActivity : ComponentActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        auth = FirebaseAuth.getInstance()

        oneTapClient = Identity.getSignInClient(this)
        signUpRequest = BeginSignInRequest.builder()
            .setGoogleIdTokenRequestOptions(
                BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                    .setSupported(true)
                    // Your server's client ID, not your Android client ID.
                    .setServerClientId("864405368873-c48cqataemj3uni5eb1maou66m3r94om.apps.googleusercontent.com")
                    // Show all accounts on the device.
                    .setFilterByAuthorizedAccounts(false)
                    .build()
            )
            .build()

        setContent {
            LoginComposeTheme {
                val navController = rememberNavController()
                val viewModel: LoginViewModel by viewModels()
                val firebaseViewModel: FirebaseViewModel by viewModels()
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    NavigationHost(
                        navController = navController,
                        viewModel = viewModel,
                        firebaseViewModel = firebaseViewModel,
                        this
                    )
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        if (currentUser != null) {
            startActivity(Intent(this, HomeActivity::class.java))
        }
    }

    companion object {
        lateinit var oneTapClient: SignInClient
        lateinit var signUpRequest: BeginSignInRequest
    }
}

