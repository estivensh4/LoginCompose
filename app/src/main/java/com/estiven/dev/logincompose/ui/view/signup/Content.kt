package com.estiven.dev.logincompose.ui.view.signup

import android.app.Activity
import android.content.Intent
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Snackbar
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.West
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.estiven.dev.logincompose.R
import com.estiven.dev.logincompose.ui.view.ButtonSocialNetwork
import com.estiven.dev.logincompose.ui.view.CustomButton
import com.estiven.dev.logincompose.ui.view.HomeActivity
import com.estiven.dev.logincompose.ui.view.navigation.NavItems
import com.estiven.dev.logincompose.ui.viewmodel.FirebaseViewModel
import com.estiven.dev.logincompose.ui.viewmodel.LoginViewModel
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions

@Composable
fun Content(
    navController: NavController,
    viewModel: LoginViewModel,
    firebaseViewModel: FirebaseViewModel,
    activity: Activity
) {
    val callbackManger = CallbackManager.Factory.create()
    var fullName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    val message: String by viewModel.message.observeAsState("")
    val loading: Boolean by viewModel.loading.observeAsState(false)
    val scrollState = rememberScrollState()
    val launcher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == Activity.RESULT_OK) {
                val task = GoogleSignIn.getSignedInAccountFromIntent(it.data)
                task.addOnSuccessListener { account ->
                    viewModel.signUpWithGoogle(account.idToken!!, firebaseViewModel)
                    activity.startActivity(Intent(activity, HomeActivity::class.java))
                    activity.finish()
                }
                task.addOnFailureListener { error ->
                    Log.d("TAG", error.message!!)
                }
            } else {
                Log.d("TAG", "No")
            }
        }
    val launcherFacebook =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == Activity.RESULT_OK) {
                callbackManger.onActivityResult(it.resultCode, it.resultCode, it.data)
            }
        }
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        if (message.isNotEmpty()) {
            Snackbar(
                modifier = Modifier.padding(4.dp)
            ) {
                Text(
                    text = message
                )
            }
        }
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
            modifier = Modifier
                .padding(32.dp)
                .verticalScroll(state = scrollState),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Create Account",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 30.sp
            )
            Spacer(modifier = Modifier.height(15.dp))
            CustomTextField(
                icon = Icons.Outlined.PersonOutline,
                label = "FULL NAME",
                value = fullName,
                type = KeyboardType.Text
            ) {
                fullName = it
            }
            CustomTextField(
                icon = Icons.Outlined.MailOutline,
                label = "EMAIL",
                value = email,
                type = KeyboardType.Email
            ) {
                email = it
            }
            CustomTextField(
                icon = Icons.Outlined.Lock,
                label = "PASSWORD",
                value = password,
                type = KeyboardType.Number
            ) {
                password = it
            }
            CustomTextField(
                icon = Icons.Outlined.Lock,
                label = "CONFIRM PASSWORD",
                value = confirmPassword,
                type = KeyboardType.Password
            ) {
                confirmPassword = it
            }
            CustomButton(
                icon = Icons.Outlined.East,
                text = "SIGN UP",
                loading = loading,
                active = true
            ) {
                viewModel.signUpWithEmail(fullName, email, password, firebaseViewModel)
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                ButtonSocialNetwork(
                    icon = R.drawable.facebook,
                    text = "FACEBOOK",
                    loading = loading,
                    active = true
                ) {
                   LoginManager.getInstance()
                       .logInWithReadPermissions(activity, listOf("email", "public_profile"))
                    LoginManager.getInstance()
                        .registerCallback(callbackManger, object : FacebookCallback<LoginResult> {
                            override fun onSuccess(result: LoginResult?) {
                                result?.let {
                                    viewModel.signUpWithFacebook(it.accessToken)
                                }
                                Log.d("FacebookLogin", "Success ${result?.accessToken}")
                            }

                            override fun onCancel() {
                                Log.d("FacebookLogin", "Cancel")
                            }

                            override fun onError(error: FacebookException?) {
                                Log.d("FacebookLogin", "Error ${error?.message}")

                            }

                        })
                }
                ButtonSocialNetwork(
                    icon = R.drawable.google,
                    text = "GOOGLE",
                    loading = loading,
                    active = true
                ) {
                    val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                        .requestIdToken("126323324378-601pb2ssl8sovlkg25rm28p7u26q0svb.apps.googleusercontent.com")
                        .requestEmail()
                        .build()
                    val googleSignInClient = GoogleSignIn.getClient(activity, gso)
                    val signInIntent = googleSignInClient.signInIntent
                    launcher.launch(signInIntent)
                }
            }
        }
    }
}
