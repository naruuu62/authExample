package com.example.authexample.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.authexample.R

@Composable

fun AuthField(text: String, onValueChange: (String) -> Unit, placeholder: String, label: String, onClick: (String) -> Unit,  leadingIcon: Int? = null, isError: Boolean = false,
errorMessage: String? = null ){
//    var label = remember {""}
    OutlinedTextField(
        value = text,
        isError = isError,
        onValueChange = onValueChange,
        modifier = Modifier.fillMaxWidth(),
        placeholder = {Text(placeholder)},
//        keyboardActions = KeyboardActions(
//            onAny = {label = label},
//        ),
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Next
        ),
        label = {Text(label)},
        singleLine = true,
        shape = RoundedCornerShape(12.dp),
        leadingIcon = {
            leadingIcon?.let {
                Icon(
                    painter = painterResource(id = it),
                    contentDescription = null,
                )
            }
        },
        enabled = true,
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color.LightGray,
            unfocusedBorderColor = Color.LightGray,
            focusedLabelColor = Color.Black,
            unfocusedLabelColor = Color.Black,
            unfocusedContainerColor = Color.Transparent,
            focusedContainerColor = Color.Transparent,
            errorBorderColor = Color.Red,
            errorLabelColor = Color.Red
        )
    )
    if (isError && errorMessage != null) {
        Text(
            text = errorMessage,
            color = Color.Red,
            fontSize = 12.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, top = 4.dp),
            textAlign = TextAlign.Start
        )
    }

}

@Composable
fun AuthFieldWithEye(text: String, onValueChange: (String) -> Unit, placeholder: String, label: String, onClick: (String) -> Unit, isError: Boolean = false, errorMessage: String?=null) {
    var passwordVisible by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = text,
        isError = isError,
        onValueChange = onValueChange,
        placeholder = { Text(placeholder) },
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Next
        ),
        visualTransformation = if (passwordVisible == true) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        },
        label = { Text(label) },
        singleLine = true,
        shape = RoundedCornerShape(12.dp),
        leadingIcon = {
            Image(
                painter = painterResource(R.drawable.password),
                contentDescription = null
            )
        },
        trailingIcon = if (passwordVisible == true) {
            {
                IconButton(onClick = ({ passwordVisible = false })) {
                    Icon(
                        painter = painterResource(id = R.drawable.pass_visible),
                        contentDescription = null
                    )
                }
            }
        } else {
            {
                IconButton(onClick = ({ passwordVisible = true })) {
                    Icon(painter = painterResource(R.drawable.pass_hide), contentDescription = null)
                }
            }
        },
        enabled = true,
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color.LightGray,
            unfocusedBorderColor = Color.LightGray,
            focusedLabelColor = Color.Black,
            unfocusedLabelColor = Color.Black,
            unfocusedContainerColor = Color.Transparent,
            focusedContainerColor = Color.Transparent,
            errorBorderColor = Color.Red,
        )
    )
    if (isError && errorMessage != null) {
        Text(
            text = errorMessage,
            color = Color.Red,
            fontSize = 12.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, top = 4.dp),
            textAlign = TextAlign.Start
        )
    }
}




