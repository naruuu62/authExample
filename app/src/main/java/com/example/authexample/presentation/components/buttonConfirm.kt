package com.example.authexample.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.authexample.R
import com.example.authexample.ui.theme.PoppinsFamily
import com.example.authexample.ui.theme.fontColor

@Composable

fun ButtonConfirm(text: String, onClick: ()-> Unit){
    Button(onClick = ({
        onClick()
    }), modifier = Modifier.fillMaxWidth(), colors = ButtonColors(
        containerColor = fontColor,
        disabledContainerColor = Color.LightGray,
        contentColor = Color.White,
        disabledContentColor = Color.LightGray
    )) {
        Text(text, style = TextStyle(fontSize = 20.sp, fontFamily = PoppinsFamily, color = Color.White))
    }
}

@Composable
fun GoogleButton(onClicked: () -> Unit) {
    Button(
        onClick = ({
            onClicked
        }),
        colors = ButtonColors(
            containerColor = Color.White,
            contentColor = fontColor,
            disabledContentColor = fontColor,
            disabledContainerColor = Color.LightGray
        ),
        modifier = Modifier
            .padding(2.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(painterResource(R.drawable.google), contentDescription = null, modifier = Modifier.size(14.dp))

        }

    }
}

@Composable
fun AppleButton(onClicked: () -> Unit) {
    Button(
        onClick = ({
            onClicked
        }),
        colors = ButtonColors(
            containerColor = Color.White,
            contentColor = fontColor,
            disabledContentColor = fontColor,
            disabledContainerColor = Color.LightGray
        ),
        modifier = Modifier
            .padding(2.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(painterResource(R.drawable.apple), contentDescription = null, modifier = Modifier.size(14.dp))
            Spacer(modifier = Modifier.width(8.dp))


        }

    }
}