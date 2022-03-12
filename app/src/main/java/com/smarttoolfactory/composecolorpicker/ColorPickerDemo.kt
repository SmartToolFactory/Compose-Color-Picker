package com.smarttoolfactory.composecolorpicker

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.smarttoolfactory.colorpicker.ColorPickerWheel
import com.smarttoolfactory.colorpicker.slider.ColorfulSlider
import com.smarttoolfactory.colorpicker.SaturationRhombus
import com.smarttoolfactory.colorpicker.ui.Blue400

@Composable
fun ColorPickerImplementation() {
    Column(
        modifier = Modifier
//            .background(Color(0xff424242))
            .fillMaxSize()
            .padding(8.dp)
    ) {

        var hue by remember { mutableStateOf(0f) }
        var saturation by remember { mutableStateOf(0.5f) }
        var lightness by remember { mutableStateOf(0.5f) }

        val color = Color.hsl(hue = hue, saturation = saturation, lightness = lightness)

        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            var colorValue by remember { mutableStateOf(0f) }

            Spacer(modifier = Modifier.height(50.dp))
            ColorfulSlider(
                value = colorValue,
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .fillMaxWidth()
                    .border(2.dp, Color.Green),
                thumbRadius = 8.dp,
                trackHeight = 6.dp,
                onValueChange = {
                    colorValue = it
                    println("😍PROGRESS $it")
                }

            )

            var progress by remember {
                mutableStateOf(0f)
            }
            Slider(modifier = Modifier
                .padding(horizontal = 20.dp)
                .border(2.dp, Color.Green), value = progress,
                onValueChange = {
                    println("🎃 Slider progress $it")
                    progress = it
                }
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Color",
                color = Blue400,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 12.dp)
            )

            // Initial and Current Colors
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 50.dp, vertical = 20.dp)
            ) {

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(40.dp)
                        .background(
                            Color.Black,
                            shape = RoundedCornerShape(topStart = 8.dp, bottomStart = 8.dp)
                        )
                )
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(40.dp)
                        .background(
                            color,
                            shape = RoundedCornerShape(topEnd = 8.dp, bottomEnd = 8.dp)
                        )
                )
            }

            // ColorWheel for hue selection
            // SaturationRhombus for saturation and lightness selections
            Box(
                modifier = Modifier.padding(8.dp),
                contentAlignment = Alignment.Center
            ) {

                ColorPickerWheel(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f),
                    selectionRadius = 8.dp
                ) { hueChange ->
                    hue = hueChange.toFloat()
                }

                SaturationRhombus(
                    modifier = Modifier.size(200.dp),
                    hue = hue,
                    saturation = saturation,
                    lightness = lightness,
                    selectionRadius = 8.dp
                ) { s, l ->
                    println("CHANGING sat: $s, lightness: $l")
                    saturation = s
                    lightness = l
                }
            }

            // Sliders
            ColorSlider(
                modifier = Modifier
                    .padding(start = 12.dp, end = 12.dp)
                    .fillMaxWidth(),
                title = "Hue",
                titleColor = Color.Red,
                rgb = hue,
                onColorChanged = {
                    hue = it
                },
                valueRange = 0f..360f
            )
            Spacer(modifier = Modifier.height(4.dp))
            ColorSlider(
                modifier = Modifier
                    .padding(start = 12.dp, end = 12.dp)
                    .fillMaxWidth(),
                title = "Saturation",
                titleColor = Color.Green,
                rgb = saturation * 100f,
                onColorChanged = {
                    saturation = it / 100f
                },
                valueRange = 0f..100f

            )
            Spacer(modifier = Modifier.height(4.dp))

            ColorSlider(
                modifier = Modifier
                    .padding(start = 12.dp, end = 12.dp)
                    .fillMaxWidth(),
                title = "Lightness",
                titleColor = Color.Blue,
                rgb = lightness * 100f,
                onColorChanged = {
                    lightness = it / 100f
                },
                valueRange = 0f..100f
            )
        }
    }
}
