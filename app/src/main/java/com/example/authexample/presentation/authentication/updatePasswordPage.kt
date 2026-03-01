package com.example.authexample.presentation.authentication



import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
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
fun UpdatePasswordPage(
    navController: NavController,
) {

    var newPassword by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    var newPasswordError by remember { mutableStateOf<String?>(null) }
    var confirmPasswordError by remember { mutableStateOf<String?>(null) }
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
                "Buat Password Baru",
                style = TextStyle(
                    fontSize = 30.sp,
                    fontFamily = PoppinsFamily,
                    color = fontColor,
                    textAlign = TextAlign.Center
                )
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                "Silakan masukkan password baru untuk mengamankan akunmu.",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = PoppinsFamily,
                    color = Color.Black,
                    textAlign = TextAlign.Center
                )
            )

            Spacer(modifier = Modifier.height(40.dp))

            AuthField(
                text = newPassword,
                onValueChange = {
                    newPassword = it
                    if (newPasswordError != null) newPasswordError = null
                },
                placeholder = "Password Baru",
                label = "Password Baru",
                onClick = {},
                leadingIcon = R.drawable.password,
                errorMessage = newPasswordError,
                isError = newPasswordError != null
            )

            Spacer(modifier = Modifier.height(16.dp))

            AuthField(
                text = confirmPassword,
                onValueChange = {
                    confirmPassword = it
                    if (confirmPasswordError != null) confirmPasswordError = null
                },
                placeholder = "Konfirmasi Password",
                label = "Konfirmasi Password",
                onClick = {},
                leadingIcon = R.drawable.password,
                errorMessage = confirmPasswordError,
                isError = confirmPasswordError != null
            )

            Spacer(modifier = Modifier.height(30.dp))

            ButtonConfirm(
                text = "Simpan Password",
                onClick = {
                    newPasswordError = AuthValidator.validatePassword(newPassword)

                    if (confirmPassword.isEmpty()) {
                        confirmPasswordError = "Konfirmasi password tidak boleh kosong"
                    } else if (newPassword != confirmPassword) {
                        confirmPasswordError = "Password tidak cocok"
                    } else {
                        confirmPasswordError = null
                    }

                    if (newPasswordError == null && confirmPasswordError == null) {

                    }
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
        }

//        if (viewModel.isLoading) {
//            CircularProgressIndicator(
//                modifier = Modifier.align(Alignment.Center)
//            )
        }
    }