package com.estiven.dev.logincompose.ui.view.navigation

sealed class NavItems(val route: String) {
    object SignIn : NavItems("signIn")
    object SignUp : NavItems("signUp")
}
