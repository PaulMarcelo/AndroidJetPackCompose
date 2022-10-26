package ec.com.pmyb.jetpackcomposeinstagram

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import dagger.hilt.android.AndroidEntryPoint
import ec.com.pmyb.jetpackcomposeinstagram.login.ui.LoginScreen
import ec.com.pmyb.jetpackcomposeinstagram.login.ui.LoginViewModel
import ec.com.pmyb.jetpackcomposeinstagram.ui.theme.JetpackComposeInstagramTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeInstagramTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colors.background
                    color = Color(0xFFE4E3E3)
                ) {
                    LoginScreen(loginViewModel)
                }
            }
        }
    }
}
