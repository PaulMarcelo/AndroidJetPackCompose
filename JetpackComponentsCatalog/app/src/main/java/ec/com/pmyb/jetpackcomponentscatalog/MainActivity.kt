package ec.com.pmyb.jetpackcomponentscatalog

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.rounded.Star
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import ec.com.pmyb.jetpackcomponentscatalog.ui.CheckInfo
import ec.com.pmyb.jetpackcomponentscatalog.ui.theme.JetpackComponentsCatalogTheme
import kotlin.math.exp


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Logger.addLogAdapter(AndroidLogAdapter())
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComponentsCatalogTheme {
                // A surface container using the 'background' color from the theme
//                var selected by remember{
//                    mutableStateOf("Paul")
//                }
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    var show by remember {
                        mutableStateOf(false)
                    }
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Button(onClick = { show = true }) {
                            Text(text = "Mostrar Dialogo")
                        }
                        MyDialog(
                            show,
                            onDismiss = { show = false },
                            { Log.i("Mensaje", "Mensaje confirmacion") })
                    }
//                    MyText("Android")
//                    var myText by remember { mutableStateOf("PAUl") }
//                    MyTextField(myText) {
//                        myText = it
//                    }
//                    MyTextFieldAdvance()
//                    Column {
//                        MyTextFieldOutLine()
//                        MyButtonExample()
//                        MyIcon()
//                        MyProgressAdvance()
//                        MySwitch()
//                        val myOptions =
//                            getOptions(titles = listOf("Opcion 1", "Opcion 2", "Opcion 3"))
//                        MyTriStatusCheckBox(myOptions)
//
//                        myOptions.forEach {
//                            MyCheckBoxWithTextCompleted(it)
//                        }
//
//                        MyCheckBoxWithText()
//                        MyRadioButton()
//                        MyRadioButtonList(selected){selected=it}
//                        MyCard()
//                        MyDivider()
//                        MyDrowDownMenu()
//                        BasicSlider()
//                        AdvanceSlider()
//                        MyRangeSlider()

//                    }
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
//        MySwitch()
//        MyCheckBoxWithText()
//        MyCard()
        MyDivider()

    }
}

@Composable
fun MyDrowDownMenu() {
    var selectedText by remember {
        mutableStateOf("")
    }

    var expanded by remember {
        mutableStateOf(false)
    }

    var dessert = listOf("Helado", "Chocolate", "Cafe", "Fruta", "Natillas", "Chilaquiles")

    Column(Modifier.padding(20.dp)) {
        OutlinedTextField(value = selectedText, onValueChange = { selectedText = it },
            enabled = false, readOnly = true, modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    expanded = true
                })
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            dessert.forEach {
                DropdownMenuItem(onClick = {
                    expanded = false
                    selectedText = it
                }) {
                    Text(text = it)
                }
            }
        }
    }
}

@Composable
fun MyDivider() {
    Divider(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp), color = Color.Red
    )
}

@Composable
fun MyBagbeBox() {
    BadgedBox(modifier = Modifier.padding(16.dp),
        badge = {
            Badge { Text("800") }
        }
    ) {
        Icon(imageVector = Icons.Default.Star, contentDescription = "")
    }
}

@Composable
fun MyCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = 12.dp,
        shape = MaterialTheme.shapes.small,
        backgroundColor = Color.Gray,
        contentColor = Color.White,
        border = BorderStroke(5.dp, Color.Black)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Ejemplo1")
            Text(text = "Ejemplo2")
            Text(text = "Ejemplo3")
        }
    }
}

@Composable
fun MyRadioButtonList(name: String, onValueChange: (String) -> Unit) {
    Column(Modifier.fillMaxWidth()) {
        Row(modifier = Modifier.fillMaxWidth()) {
            RadioButton(selected = name == "Paul",
                onClick = { onValueChange("Paul") }
            )
            Text(text = "Paul")
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            RadioButton(selected = name == "David", onClick = { onValueChange("David") })
            Text(text = "David")
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            RadioButton(selected = name == "Maria", onClick = { onValueChange("Maria") })
            Text(text = "Maria")
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            RadioButton(selected = name == "Pepe", onClick = { onValueChange("Pepe") })
            Text(text = "Pepe")
        }
    }
}


@Composable
fun MyRadioButton() {

    Row(modifier = Modifier.fillMaxWidth()) {
        RadioButton(
            selected = false, onClick = { /*TODO*/ },
            enabled = true,
            colors = RadioButtonDefaults.colors(
                selectedColor = Color.Red,
                unselectedColor = Color.Yellow,
                disabledColor = Color.Green
            )
        )
        Text(text = "Ejemplo1")
    }


}

@Composable
fun MyTriStatusCheckBox(option: List<CheckInfo>) {
    var status by rememberSaveable {
        mutableStateOf(ToggleableState.Off)
    }
    TriStateCheckbox(state = status, onClick = {
        status = when (status) {
            ToggleableState.On -> {
                option.map {
                    it.seleted = true
                }
                ToggleableState.Off
            }
            ToggleableState.Off -> ToggleableState.Indeterminate
            ToggleableState.Indeterminate -> ToggleableState.On
        }

    })

}


@Composable
fun MyCheckBoxWithTextCompleted(checkInfo: CheckInfo) {
    Row(Modifier.padding(8.dp)) {
        Checkbox(
            checked = checkInfo.seleted,
            onCheckedChange = { checkInfo.onCheckedChange(!checkInfo.seleted) }
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = checkInfo.title, modifier = Modifier.padding(top = 8.dp))
    }
}

@Composable
fun getOptions(titles: List<String>): List<CheckInfo> {
    return titles.map {
        var status by rememberSaveable {
            mutableStateOf(false)
        }
        CheckInfo(it, status) { myNewStatus -> status = myNewStatus }
    }
}

@Composable
fun MyCheckBoxWithText() {
    var status by rememberSaveable {
        mutableStateOf(true)
    }
    Row(Modifier.padding(8.dp)) {
        Checkbox(
            checked = status, onCheckedChange = { status = !status }
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = "Ejemplo 1", modifier = Modifier.padding(top = 8.dp))
    }
}


@Composable
fun MyCheckBox() {
    var status by rememberSaveable {
        mutableStateOf(true)
    }
    Checkbox(
        checked = status, onCheckedChange = { status = !status }, enabled = true,
        colors = CheckboxDefaults.colors(
            checkedColor = Color.Red,
            uncheckedColor = Color.Yellow,
            checkmarkColor = Color.Blue
        )
    )
}

@Composable
fun MySwitch() {
    var status by rememberSaveable {
        mutableStateOf(true)
    }
    Switch(
        checked = status, onCheckedChange = { status = !status }, enabled = true,
        colors = SwitchDefaults.colors(
            uncheckedThumbColor = Color.Red,
            checkedThumbColor = Color.Green,
            checkedTrackColor = Color.Cyan,
            uncheckedTrackColor = Color.Magenta
        )
    )
}

@Composable
fun MyProgressAdvance() {
    var progresstatus by rememberSaveable {
        mutableStateOf(0f)
    }

    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
//        CircularProgressIndicator(progress = progresstatus)
        LinearProgressIndicator(progress = progresstatus)
        Row(Modifier.fillMaxWidth()) {
            Button(onClick = {
                if (progresstatus < 1.0f) {
                    progresstatus += 0.1f
                }
            }) {
                Text(text = "Incrementar")
            }
            Button(onClick = {
                if (progresstatus > 0.000000000000f) {
                    progresstatus -= 0.1f
                }
            }) {
                Text(text = "reducir")
            }

        }
    }
}

@Composable
fun MyProgress() {
    var showLoading by rememberSaveable {
        mutableStateOf(false)
    }
    Column(
        Modifier
            .padding(24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (showLoading) {
            CircularProgressIndicator(color = Color.Red, strokeWidth = 5.dp)
            LinearProgressIndicator(
                modifier = Modifier.padding(32.dp),
                color = Color.Red,
                backgroundColor = Color.Gray
            )
        }
        Button(onClick = { showLoading = !showLoading }) {
            Text("Cargar Perfil")
        }
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
