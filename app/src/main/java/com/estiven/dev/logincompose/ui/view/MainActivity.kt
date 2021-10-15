package com.estiven.dev.logincompose.ui.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.rememberNavController
import com.estiven.dev.logincompose.ui.theme.LoginComposeTheme
import com.estiven.dev.logincompose.ui.view.navigation.NavigationHost
import com.estiven.dev.logincompose.ui.viewmodel.LoginViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginComposeTheme {
                val navController = rememberNavController()
                val viewModel: LoginViewModel by viewModels()
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    NavigationHost(navController = navController, viewModel = viewModel)
                }
            }
        }
    }
}

