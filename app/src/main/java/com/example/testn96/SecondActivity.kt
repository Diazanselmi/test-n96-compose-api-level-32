package com.example.testn96

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import cl.multicaja.klapcomercio.signup.juridical.navigation.RoutesJuridical
import com.example.testn96.navigation.NavigationJuridical1
import com.example.testn96.navigation.NavigationJuridical2
import com.example.testn96.ui.theme.TestN96Theme

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestN96Theme() {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    NavigationJuridical2(
                        startDestination = RoutesJuridical.BankDataScreen.route,
                        navigateFirstActivity = {
                            startActivity(Intent(this, MainActivity::class.java))
                            finish()
                        }
                    )
                }
            }
        }
    }
}