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
import com.example.authexample.ui.theme.PoppinsFamily
import com.example.authexample.ui.theme.fontColor
import com.example.authexample.presentation.components.AppleButton
import com.example.authexample.presentation.components.AuthField
import com.example.authexample.presentation.components.AuthFieldWithEye
import com.example.authexample.presentation.components.ButtonConfirm
import com.example.authexample.presentation.components.GoogleButton

@Composable

fun LoginPage(navController: NavController){
    var email by remember { mutableStateOf("") }
    var password by remember {mutableStateOf("")}
    var label by remember { mutableStateOf("") }


    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(horizontal = 50.dp)
    ) {
        Column(){


        Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(horizontal = 12.dp)
    ) {
            Text(
                "Selamat Datang!",
                style = TextStyle(
                    fontSize = 32.sp,
                    fontFamily = PoppinsFamily,
                    color = fontColor,
                    textAlign = TextAlign.Center
                )
            )
            Spacer(modifier = Modifier.height(3.dp))
            Text(
                "Masuk ke akunmu",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontFamily = PoppinsFamily,
                    color = Color.Black,
                    textAlign = TextAlign.Center
                )
            )
            Spacer(modifier = Modifier.height(30.dp))

            AuthField(
                text = email,
                onValueChange = { email = it },
                placeholder = "Email",
                label = "Email",
                onClick = { label = "Email" }
            )

            Spacer(modifier = Modifier.height(12.dp))
            AuthFieldWithEye(
                text = password,
                onValueChange = { password = it },
                placeholder = "Kata Sandi",
                label = "Kata Sandi",
                onClick = { label = "Kata Sandi" }
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier.fillMaxWidth()
            ) {
                Spacer(modifier = Modifier.width(20.dp))
                Text(
                    "Lupa kata sandi?",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontFamily = PoppinsFamily,
                        fontWeight = FontWeight.Thin,
                        color = fontColor
                    )
                )
            }

            Spacer(modifier = Modifier.height(80.dp))
            ButtonConfirm(text = "Masuk", onClick = ({}))

            Text("---------- atau masuk dengan -----------", color = Color.Black, fontWeight = FontWeight.Thin, fontSize = 12.sp,
                fontFamily = PoppinsFamily)
            Spacer(modifier = Modifier.height(20.dp))
            Row() {
                AppleButton(onClicked = ({}))
                Spacer(modifier = Modifier.width(20.dp))
                GoogleButton(onClicked = ({}))
            }
            Spacer(modifier = Modifier.height(15.dp))
            Row() {
                Text("Belum memiliki akun? ",
                    color = Color.Black,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                    textAlign = TextAlign.End)

                Text("Daftar",
                    color = fontColor,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    textAlign = TextAlign.End,
                    modifier = Modifier.clickable{(navController.navigate("signup"))}
                )
            }
        }

    }

    }
}