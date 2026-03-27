package com.example.login

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

class PreferenceManager(context: Context){
    private val sharedPreferences = context.getSharedPreferences("session_prefs", Context.MODE_PRIVATE)

    fun saveLoginStatus(isLoggedIn: Boolean){
        sharedPreferences.edit { putBoolean("isLoggedIn", true) }
    }

    fun isLoggedIn(): Boolean{
        return sharedPreferences.getBoolean("isLoggedIn", false)
    }

    fun logout(){
        //Solo una variable
        //sharedPreferences.edit { remove("isLoggedIn").apply() }
        //Limpiar todo
        sharedPreferences.edit { clear().apply() }
    }
}
