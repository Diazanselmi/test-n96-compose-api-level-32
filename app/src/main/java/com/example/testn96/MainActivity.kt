package com.example.testn96

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import cl.multicaja.klapcomercio.signup.juridical.navigation.RoutesJuridical
import com.example.testn96.navigation.NavigationJuridical1
import com.example.testn96.ui.theme.TestN96Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestN96Theme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    NavigationJuridical1(
                        startDestination = RoutesJuridical.WelcomeScreen.route,
                        navigateSecondActivity = {
                            startActivity(Intent(this, SecondActivity::class.java))
                            finish()
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TestN96Theme {
        Greeting("Android")
    }
}