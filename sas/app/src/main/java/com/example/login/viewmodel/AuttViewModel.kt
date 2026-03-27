package com.example.login.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.login.data.DataStoreManager
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.WhileSubscribed
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class AuttViewModel(private val dataStore: DataStoreManager): ViewModel(){
    val isLoggednIn = dataStore.isLoggedFlow.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        false
    )

    fun login(user: String, pass: String){
        if(user === "admin" && pass === "1234"){
            viewModelScope.launch {
                dataStore.saveSession(user)
            }
        }
    }

    fun logout(){
        viewModelScope.launch {
            dataStore.logout()
        }
    }
}