package ec.com.pmyb.jetpackcomponentscatalog

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun ScaffoldExample() {
    val scaffoldState = rememberScaffoldState()
    val corutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            MyTopAppBar(onCliclIcon = {
                corutineScope.launch {
                    scaffoldState.snackbarHostState.showSnackbar(" Has pulsado  $it")
                }
            }, onClickDrawer = { corutineScope.launch { scaffoldState.drawerState.open() } })
        }, scaffoldState = scaffoldState,
        bottomBar = { MyBottomNavigator() }, floatingActionButton = { MyFab() },
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.Center,
        drawerContent = {
            MyDrawer {
                corutineScope.launch { scaffoldState.drawerState.close() }
            }
        },
        drawerGesturesEnabled = false
    ) {}
}

@Composable
fun MyTopAppBar(onCliclIcon: (String) -> Unit, onClickDrawer: () -> Unit) {
    TopAppBar(title = {
        Text(text = "Toll Bar")
    },
        backgroundColor = Color.Red,
        contentColor = Color.White,
        elevation = 4.dp,
        navigationIcon = {
            IconButton(onClick = { onClickDrawer() }) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "")
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

@Composable
fun MyBottomNavigator() {
    var index by remember {
        mutableStateOf(0)
    }
    BottomNavigation(backgroundColor = Color.Red, contentColor = Color.White) {
        BottomNavigationItem(selected = index == 0, onClick = { index = 0 }, icon = {
            Icon(imageVector = Icons.Default.Home, contentDescription = "")
        }, label = { Text(text = "Home") })
//        BottomNavigationItem(selected = index == 1, onClick = { index = 1 }, icon = {
//            Icon(imageVector = Icons.Default.Favorite, contentDescription = "")
//        }, label = { Text(text = "FAV") })
        BottomNavigationItem(selected = index == 2, onClick = { index = 2 }, icon = {
            Icon(imageVector = Icons.Default.Person, contentDescription = "")
        }, label = { Text(text = "Person") })
    }
}

@Composable
fun MyFab() {
    FloatingActionButton(onClick = { }, backgroundColor = Color.Green, contentColor = Color.White) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = "")
    }
}

@Composable
fun MyDrawer(onCloseDrawer: () -> Unit) {
    Column(Modifier.padding(8.dp)) {
        Text(
            text = "Primera Opcion", modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .clickable { onCloseDrawer() }
        )
        Text(
            text = "Segunda Opcion", modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .clickable { onCloseDrawer() }
        )
        Text(
            text = "Tercera Opcion", modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .clickable { onCloseDrawer() }
        )
        Text(
            text = "Cuarta Opcion", modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .clickable { onCloseDrawer() }
        )
    }
}