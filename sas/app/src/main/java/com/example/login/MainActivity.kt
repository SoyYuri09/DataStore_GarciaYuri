package com.example.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.login.data.DataStoreManager
import com.example.login.ui.screens.HomeScreen
import com.example.login.ui.screens.LoginScreen
import com.example.login.ui.screens.MainScreen
import com.example.login.ui.theme.LoginTheme
import com.example.login.viewmodel.AuttViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val prefManager = PreferenceManager(this)

        enableEdgeToEdge()
        setContent {
            LoginTheme {
                MainScreen(AuttViewModel(DataStoreManager(this)))
            }
            //consulta si esta logeado si si esta que lo mando a la pantalla home si no está
            // logeado que lo mande al login screen, los estados osn lo que determinan si los componenetes se renderiza,
            // si oucpo que se renderice un view oh un if se ocupa cambiar el estado
        }
    }
}