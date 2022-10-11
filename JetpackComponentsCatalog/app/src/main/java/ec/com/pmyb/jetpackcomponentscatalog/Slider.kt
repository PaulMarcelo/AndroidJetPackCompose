package ec.com.pmyb.jetpackcomponentscatalog

import androidx.compose.foundation.layout.Column
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.RangeSlider
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment

@Composable
fun BasicSlider() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        var sliderPosition by remember {
            mutableStateOf(0f)
        }
        Slider(value = sliderPosition, onValueChange = { sliderPosition = it })
        Text(text = "$sliderPosition")
    }
}

@Composable
fun AdvanceSlider() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        var sliderPosition by remember {
            mutableStateOf(0f)
        }
        var completeValue by remember {
            mutableStateOf("")
        }
        Slider(
            value = sliderPosition, onValueChange = { sliderPosition = it },
            onValueChangeFinished = { completeValue = sliderPosition.toString() },
            valueRange = 0f..10f,
            steps = 9,
            enabled = true
        )
        Text(text = completeValue)
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MyRangeSlider() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        var currentRage by remember {
            mutableStateOf(0f..10f)
        }
        RangeSlider(
            values = currentRage, onValueChange = { currentRage = it },
            valueRange = 0f..10f,
            steps = 9,
            enabled = true
        )
        Text(text = "Valor inferior: ${currentRage.start}")
        Text(text = "Valor superior: ${currentRage.endInclusive}")
    }
}