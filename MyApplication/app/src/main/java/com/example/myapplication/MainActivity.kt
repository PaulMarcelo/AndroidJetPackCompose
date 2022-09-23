package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    //Greeting("Android")
                    MySuperText("")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Helloaaaaaa asdadasdadads $name!")
}

@Preview(
    name = "PREVIEW 1",
//    widthDp = 200,
//    heightDp = 50,
    showBackground = true,
    showSystemUi = true,
    apiLevel = 29,
    device = Devices.NEXUS_5
)
@Composable
fun MyTestSuperTes() {
    MySuperText(name = "PEPE")
}

@Composable
fun MySuperText(name: String) {
    Text(
        text = "SOY PAUL YAGUACHI Y TU $name", modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
            //.fillMaxHeight() // match parent
            //.fillMaxWidth() // match parent
            //.height(50.dp)
            //.width(50.dp)
            .clickable {}
    )
}
