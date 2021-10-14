package com.estiven.dev.logincompose.ui.view.signin

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.estiven.dev.logincompose.ui.view.navigation.NavItems

@Composable
fun SignIn(navController: NavController) {
    Button(onClick = { navController.navigate(NavItems.SignUp.route) }) {
        Text(text = "Click para ir a la otra pantalla")
    }
}