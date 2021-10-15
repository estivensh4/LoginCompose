package com.estiven.dev.logincompose.ui.view.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.estiven.dev.logincompose.ui.view.signin.SignIn
import com.estiven.dev.logincompose.ui.view.signup.SignUp
import com.estiven.dev.logincompose.ui.viewmodel.LoginViewModel

@Composable
fun NavigationHost(navController: NavHostController, viewModel: LoginViewModel) {
    NavHost(
        navController = navController,
        startDestination = NavItems.SignIn.route
    ) {
        composable(NavItems.SignIn.route) { SignIn(navController = navController) }
        composable(NavItems.SignUp.route) { SignUp(navController = navController, viewModel = viewModel) }
    }

}