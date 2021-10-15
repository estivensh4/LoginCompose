package com.estiven.dev.logincompose.ui.view.signup

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.estiven.dev.logincompose.ui.theme.Orange700
import com.estiven.dev.logincompose.ui.view.navigation.NavItems

@Composable
fun Footer(navController: NavController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Text(
                text = "Already have a account?"
            )
            Text(
                text = "Sign in",
                color = Orange700,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.clickable(
                    onClick = {
                        navController.navigate(NavItems.SignIn.route)
                    }
                )
            )
        }
    }
}