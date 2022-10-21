package ec.com.pmyb.jetpackcomponentscatalog

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Dangerous
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun ScaffoldExample() {
    val scaffoldState = rememberScaffoldState()
    val corutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            MyTopAppBar {
                corutineScope.launch {
                    scaffoldState.snackbarHostState.showSnackbar(" Has pulsado  $it")
                }
            }
        }, scaffoldState = scaffoldState
    ) {}
}

@Composable
fun MyTopAppBar(onCliclIcon: (String) -> Unit) {
    TopAppBar(title = {
        Text(text = "Toll Bar")
    },
        backgroundColor = Color.Red,
        contentColor = Color.White,
        elevation = 4.dp,
        navigationIcon = {
            IconButton(onClick = { onCliclIcon("Atrás") }) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "")
            }
        },
        actions = {
            IconButton(onClick = { onCliclIcon("Buscar") }) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "")
            }
            IconButton(onClick = { onCliclIcon("Peligro") }) {
                Icon(imageVector = Icons.Filled.Dangerous, contentDescription = "")
            }
        })
}