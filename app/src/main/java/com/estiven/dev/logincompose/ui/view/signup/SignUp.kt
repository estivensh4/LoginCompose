package com.estiven.dev.logincompose.ui.view.signup

import android.app.Activity
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.estiven.dev.logincompose.ui.viewmodel.FirebaseViewModel
import com.estiven.dev.logincompose.ui.viewmodel.LoginViewModel

@Composable
fun SignUp(
    navController: NavController,
    viewModel: LoginViewModel,
    firebaseViewModel: FirebaseViewModel,
    activity: Activity
) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Content(
            navController = navController,
            viewModel = viewModel,
            firebaseViewModel,
            activity = activity
        )
        Footer(navController = navController)
    }
}