package com.example.authexample.common.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.authexample.presentation.authentication.LoginPage
import com.example.authexample.presentation.authentication.SignupPage

@Composable
fun RouteClass(navHostController: NavHostController){
    NavHost(navController = navHostController, startDestination = "signup"){
        composable("login") { LoginPage(navHostController) }
        composable("signup") { SignupPage(navHostController) }
    }
}
