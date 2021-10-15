package com.estiven.dev.logincompose.ui.view.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.West
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.estiven.dev.logincompose.R
import com.estiven.dev.logincompose.ui.view.CustomButton
import com.estiven.dev.logincompose.ui.view.navigation.NavItems
import com.estiven.dev.logincompose.ui.viewmodel.LoginViewModel

@Composable
fun Content(navController: NavController, viewModel: LoginViewModel) {
    var fullName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(
                onClick = {
                    navController.navigate(NavItems.SignIn.route)
                },
                modifier = Modifier.padding(16.dp, 0.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.West,
                    contentDescription = null
                )
            }
            Image(
                painter = painterResource(id = R.drawable.figure),
                contentDescription = "Figura del signUp",
                modifier = Modifier
                    .size(170.dp)
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Column(
            modifier = Modifier.padding(32.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Create Account",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 30.sp
            )
            Spacer(modifier = Modifier.height(15.dp))
            CustomTextField(icon = Icons.Outlined.PersonOutline, label = "FULL NAME", fullName)
            CustomTextField(icon = Icons.Outlined.MailOutline, label = "EMAIL", email)
            CustomTextField(icon = Icons.Outlined.Lock, label = "PASSWORD", password)
            CustomTextField(icon = Icons.Outlined.Lock, label = "CONFIRM PASSWORD", confirmPassword)
            CustomButton(icon = Icons.Outlined.East, text = "SIGN UP") {
                viewModel.signUp(fullName, email, password)
            }
        }
    }
}
