package com.example.login.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.login.viewmodel.AuttViewModel

@Composable
fun MainScreen(viewModel: AuttViewModel){
    val isLoggedIn by viewModel.isLoggednIn.collectAsState()
    if(isLoggedIn){
        HomeScreen({ viewModel.logout() })
    } else {
        LoginScreen(viewModel)
    }
}