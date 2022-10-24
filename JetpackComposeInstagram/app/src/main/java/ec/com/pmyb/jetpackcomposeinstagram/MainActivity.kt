package ec.com.pmyb.jetpackcomposeinstagram

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import ec.com.pmyb.jetpackcomposeinstagram.login.ui.LoginScreen
import ec.com.pmyb.jetpackcomposeinstagram.login.ui.LoginViewModel
import ec.com.pmyb.jetpackcomposeinstagram.ui.theme.JetpackComposeInstagramTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeInstagramTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colors.background
                    color = Color(0xFFE4E3E3)
                ) {
                    LoginScreen(LoginViewModel())
                }
            }
        }
    }
}
