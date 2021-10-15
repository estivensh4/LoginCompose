package com.estiven.dev.logincompose.ui.view.signup

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.estiven.dev.logincompose.ui.viewmodel.LoginViewModel

@Composable
fun SignUp(navController: NavController, viewModel: LoginViewModel) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxSize()
    ) {
        Content(navController = navController, viewModel = viewModel)
        Footer(navController = navController)
    }
}