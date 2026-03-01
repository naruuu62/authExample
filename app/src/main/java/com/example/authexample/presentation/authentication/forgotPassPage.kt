@file:JvmName("ResetPasswordPageKt")

package com.example.authexample.presentation.authentication

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.authexample.R
import com.example.authexample.presentation.components.AuthField
import com.example.authexample.presentation.components.ButtonConfirm
import com.example.authexample.ui.theme.PoppinsFamily
import com.example.authexample.ui.theme.fontColor
import com.example.authexample.utils.AuthValidator


@Composable
fun ResetPasswordPage(
    navController: NavController,
) {

    var email by remember { mutableStateOf("") }
    var emailError by remember { mutableStateOf<String?>(null) }
    var message by remember { mutableStateOf<String?>(null) }


    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 30.dp)
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {

            Text(
                "Reset Password",
                style = TextStyle(
                    fontSize = 30.sp,
                    fontFamily = PoppinsFamily,
                    color = fontColor,
                    textAlign = TextAlign.Center
                )
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                "Masukkan email untuk menerima link reset password",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = PoppinsFamily,
                    color = Color.Black,
                    textAlign = TextAlign.Center
                )
            )

            Spacer(modifier = Modifier.height(40.dp))

            AuthField(
                text = email,
                onValueChange = {
                    email = it
                    if (emailError != null) emailError = null
                },
                placeholder = "Email",
                label = "Email",
                onClick = {},
                leadingIcon = R.drawable.email,
                errorMessage = emailError,
                isError = emailError != null
            )

            Spacer(modifier = Modifier.height(30.dp))

            ButtonConfirm(
                text = "Kirim Link Reset",
                onClick = {

                    emailError = AuthValidator.validateEmail(email)

                }
            )

            Spacer(modifier = Modifier.height(20.dp))

            message?.let {
                Text(
                    text = it,
                    color = fontColor,
                    fontSize = 13.sp,
                    textAlign = TextAlign.Center
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                "Kembali ke Login",
                color = fontColor,
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp,
                modifier = Modifier.clickable {
                    navController.navigate("login")
                }
            )
        }

//        if (viewModel.isLoading) {
//            CircularProgressIndicator(
//                modifier = Modifier.align(Alignment.Center)
//            )
//        }
    }
}