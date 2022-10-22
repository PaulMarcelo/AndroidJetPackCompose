package ec.com.pmyb.jetpackcomponentscatalog

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import ec.com.pmyb.jetpackcomponentscatalog.model.Routes

@Composable
fun Screen1(navigatorController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan)
    ) {
        Text(text = "Pantalla 1", modifier = Modifier
            .align(Alignment.Center)
            .clickable {
                navigatorController.navigate(Routes.Pantalla2.route)
            })
    }
}

@Composable
fun Screen2(navigatorController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green)
    ) {
        Text(text = "Pantalla 2", modifier = Modifier
            .align(Alignment.Center)
            .clickable {
                navigatorController.navigate(Routes.Pantalla3.route)
            })
    }
}

@Composable
fun Screen3(navigatorController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Magenta)
    ) {
        Text(text = "Pantalla 3", modifier = Modifier
            .align(Alignment.Center)
            .clickable {
//            navigatorController.navigate("pantalla4/PaulYaguachi")
                navigatorController.navigate(Routes.Pantalla4.createRoute(34))
            })
    }
}

@Composable
//fun Screen4(navigatorController: NavHostController, name: String) {
fun Screen4(navigatorController: NavHostController, age: Int) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Text(text = "Yo tengo $age años",
            modifier = Modifier
                .align(Alignment.Center)
                .clickable { navigatorController.navigate(Routes.Pantalla5.createRoute("Paul")) })
    }
}

@Composable
fun Screen5(navigatorController: NavHostController, name: String?) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Text(text = "Mi nombre es $name", modifier = Modifier.align(Alignment.Center))
    }
}