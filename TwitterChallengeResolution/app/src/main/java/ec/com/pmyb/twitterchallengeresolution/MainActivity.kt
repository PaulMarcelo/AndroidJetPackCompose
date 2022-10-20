package ec.com.pmyb.twitterchallengeresolution

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import ec.com.pmyb.twitterchallengeresolution.ui.theme.TwitterChallengeResolutionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TwitterChallengeResolutionTheme {
                //---mi solucion
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = Color(0xFF1D222A)
//                ) {
//                    PostTwitterScreen()
//                }

                //---Solucion corregida
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xFF161D26))
                ) {
                    TwitterCard()
                    TuitDivider()
                    TwitterCard()
                }

            }
        }
    }
}

