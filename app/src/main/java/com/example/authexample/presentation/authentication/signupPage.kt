@file:JvmName("SignupPageKt")

package com.example.authexample.presentation.authentication

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.authexample.R
import com.example.authexample.ui.theme.PoppinsFamily
import com.example.authexample.ui.theme.fontColor
import com.example.authexample.utils.AuthValidator
import com.example.authexample.presentation.components.AppleButton
import com.example.authexample.presentation.components.AuthField
import com.example.authexample.presentation.components.AuthFieldWithEye
import com.example.authexample.presentation.components.ButtonConfirm
import com.example.authexample.presentation.components.GoogleButton

@Composable

fun SignupPage(navController: NavController){
    var email by remember { mutableStateOf("") }
    var password by remember {mutableStateOf("")}
    var passwordConfirm by remember { mutableStateOf("") }
    var nama by remember { mutableStateOf("") }
    var label by remember { mutableStateOf("") }
    var emailError by remember { mutableStateOf<String?>(null) }
    var passwordError by remember { mutableStateOf<String?>(null) }
    var confirmError by remember { mutableStateOf<String?>(null) }
    var namaError by remember { mutableStateOf<String?>(null) }


    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(horizontal = 30.dp)
    ) {
        Column(){


            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(horizontal = 12.dp)
            ) {
                Text(
                    "Daftar",
                    style = TextStyle(
                        fontSize = 32.sp,
                        fontFamily = PoppinsFamily,
                        color = fontColor,
                        textAlign = TextAlign.Center
                    )
                )
                Spacer(modifier = Modifier.height(3.dp))
                Text(
                    "Buat akun baru kamu",
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontFamily = PoppinsFamily,
                        color = Color.Black,
                        textAlign = TextAlign.Center
                    )
                )
                Spacer(modifier = Modifier.height(30.dp))
                AuthField(
                    text = nama,
                    onValueChange = { nama = it
                        if (namaError != null) namaError = null
                                    },
                    placeholder = "Nama Lengkap",
                    label = "Nama Lengkap",
                    onClick = { label = "Nama Lengkap" },
                    leadingIcon = R.drawable.profile,
                    errorMessage = namaError,
                    isError = namaError != null
                )

                Spacer(modifier = Modifier.height(12.dp))
                AuthField(
                    text = email,
                    onValueChange = { email = it
                                    if (emailError != null) emailError = null
                                    },
                    placeholder = "Email",
                    label = "Email",
                    onClick = { label = "Email" },
                    leadingIcon = R.drawable.email,
                    errorMessage = emailError,
                    isError = emailError != null,

                )

                Spacer(modifier = Modifier.height(12.dp))
                AuthFieldWithEye(
                    text = password,
                    onValueChange = { password = it
                                    if (passwordError != null) passwordError = null
                                    },
                    placeholder = "Kata Sandi",
                    label = "Kata Sandi",
                    onClick = { label = "Kata Sandi" },
                    errorMessage = passwordError,
                    isError = passwordError != null
                )

                Spacer(modifier = Modifier.height(12.dp))
                AuthFieldWithEye(
                    text = passwordConfirm,
                    onValueChange = { passwordConfirm = it
                                    if (confirmError != null) confirmError = null
                                    },
                    placeholder = "Konfirmasi kata Sandi",
                    label = "Konfirmasi kata Sandi",
                    onClick = { label = "Konfirmasi kata Sandi"},
                    errorMessage = confirmError,
                    isError = confirmError != null

                )

                Spacer(modifier = Modifier.height(8.dp))


                Row(
                    horizontalArrangement = Arrangement.End,
                    modifier = Modifier.fillMaxWidth()
                ) {
//                    RadioButton(
//                        selected = false,
//                        onClick = { /*TODO*/ }
//                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    Text(
                        "Setuju dengan ",
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontFamily = PoppinsFamily,
                            fontWeight = FontWeight.Thin,
                            color = Color.Black
                        )

                    )
                    Text(
                        "Syarat & Ketentuan",
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontFamily = PoppinsFamily,
                            fontWeight = FontWeight.Thin,
                            color = fontColor
                        ),
                        modifier = Modifier.clickable {  }

                    )
                }

                Spacer(modifier = Modifier.height(80.dp))
                ButtonConfirm(text = "Daftar", onClick = ({
                    namaError = if(nama.isBlank()) "Nama wajib diisi" else null
                    emailError = AuthValidator.validateEmail(email)
                    passwordError = AuthValidator.validatePassword(password)
                    confirmError = AuthValidator.validateConfirmPassword(password, passwordConfirm)
                    if (namaError == null && emailError == null && passwordError == null && confirmError == null) {
                        navController.navigate("signup")
                    }
                }))

                Text("---------- atau Daftar dengan -----------", color = Color.Black, fontWeight = FontWeight.Thin, fontSize = 12.sp,
                    fontFamily = PoppinsFamily)
                Spacer(modifier = Modifier.height(20.dp))
                Row() {
                    AppleButton(onClicked = ({}))
                    Spacer(modifier = Modifier.width(20.dp))
                    GoogleButton(onClicked = ({}))
                }
                Spacer(modifier = Modifier.height(15.dp))
                Row() {
                    Text("Sudah memiliki akun? ",
                        color = Color.Black,
                        fontWeight = FontWeight.Normal,
                        fontSize = 12.sp,
                        textAlign = TextAlign.End)

                    Text("Masuk",
                        color = fontColor,
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,
                        textAlign = TextAlign.End,
                        modifier = Modifier.clickable{(navController.navigate("login"))}
                    )
                }
            }

        }

    }
}