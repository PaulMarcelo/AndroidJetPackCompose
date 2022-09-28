package ec.com.pmyb.jetpackcomponentscatalog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import ec.com.pmyb.jetpackcomponentscatalog.ui.theme.JetpackComponentsCatalogTheme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Logger.addLogAdapter(AndroidLogAdapter())
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComponentsCatalogTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
//                    MyText("Android")
//                    var myText by remember { mutableStateOf("PAUl") }
//                    MyTextField(myText) {
//                        myText = it
//                    }
//                    MyTextFieldAdvance()
                    Column {
//                        MyTextFieldOutLine()
//                        MyButtonExample()
//                        MyIcon()
                        MyProgress()
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComponentsCatalogTheme {
//        MyText("Android")
//        MyTextField()
//        MyTextFieldAdvance()
//        MyTextFieldOutLine()
        MyProgress()
    }
}

@Composable
fun MyProgress() {
    Column(
        Modifier
            .padding(24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(color = Color.Red, strokeWidth = 5.dp)
        LinearProgressIndicator(
            modifier = Modifier.padding(32.dp),
            color = Color.Red,
            backgroundColor = Color.Gray
        )
    }
}

@Composable
fun MyIcon() {
    Icon(imageVector = Icons.Rounded.Star, contentDescription = "Icono", tint = Color.Red)
}

@Composable
fun MyImageAdvance() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "Ejemplo",
        modifier = Modifier
            .clip(CircleShape)
            .border(5.dp, Color.Red, shape = CircleShape)
    )
}

@Composable
fun MyImage() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "Ejemplo", alpha = 0.5f
    )
}

@Composable
fun MyButtonExample() {
    var enable by rememberSaveable {
        mutableStateOf(true)
    }
    Column(
        Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Button(
            onClick = {
                enable = false
//                Logger.i("Esto es un ejemplo")
            },
            enabled = enable,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Red,
                contentColor = Color.White
            ),
            border = BorderStroke(5.dp, Color.Gray)
        ) {
            Text(text = "Hola")
        }

        OutlinedButton(
            onClick = {
                enable = false
            }, Modifier.padding(top = 8.dp),
            enabled = enable,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Red,
                contentColor = Color.White,
                disabledBackgroundColor = Color.DarkGray,
                disabledContentColor = Color.Magenta
            ),
            border = BorderStroke(5.dp, Color.Gray)
        ) {
            Text(text = "Hola")
        }
    }
}

@Composable
fun MyTextFieldOutLine() {
    var myText by remember { mutableStateOf("") }
    OutlinedTextField(
        value = myText,
        onValueChange = { myText = it },
        modifier = Modifier.padding(24.dp),
        label = { Text(text = "Hola") },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Magenta,
            unfocusedBorderColor = Color.Blue
        )
    )
}

@Composable
fun MyTextFieldAdvance() {
    var myText by remember { mutableStateOf("") }
    TextField(
        value = myText,
        onValueChange = {
            myText = if (it.contains("a")) {
                it.replace("a", "")
            } else {
                it
            }
        },
        label = { Text(text = "Introduce tú nombre:") })
}

@Composable
fun MyTextField(name: String, onValueChange: (String) -> Unit) {
    TextField(value = name, onValueChange = { onValueChange(it) })
}

@Composable
fun MyText(name: String) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Esto es un ejemplo")
        Text(text = "Esto es un ejemplo", color = Color.Blue)
        Text(text = "Esto es un ejemplo", fontWeight = FontWeight.ExtraBold)
        Text(text = "Esto es un ejemplo", fontWeight = FontWeight.Light)
        Text(text = "Esto es un ejemplo", style = TextStyle(fontFamily = FontFamily.Cursive))
        Text(
            text = "Esto es un ejemplo",
            style = TextStyle(textDecoration = TextDecoration.LineThrough)
        )
        Text(
            text = "Esto es un ejemplo",
            style = TextStyle(textDecoration = TextDecoration.Underline)
        )
        Text(
            text = "Esto es un ejemplo", style = TextStyle(
                textDecoration = TextDecoration.combine(
                    listOf(TextDecoration.LineThrough, TextDecoration.Underline)
                )
            )
        )
        Text(text = "Esto es un ejemplo", fontSize = 30.sp)
    }
}
