package com.smarttoolfactory.colorpicker.util

import androidx.compose.ui.graphics.Color

/*
    HEX-ColorInt Conversion
 */
fun hexToColorInt(colorString: String): Int {
    return android.graphics.Color.parseColor(colorString)
}

/*
    HEX-RGB Conversion
 */
fun hexToRGB(colorString: String): IntArray {
    val colorInt = hexToColorInt(colorString)
    return colorIntToRGBArray(colorInt)
}

fun hexToRGB(colorString: String, rgbIn: IntArray) {
    val colorInt = hexToColorInt(colorString)
    colorIntToRGBArray(colorInt, rgbIn)
}

fun hexToARGB(colorString: String): IntArray {
    val colorInt = hexToColorInt(colorString)
    return colorIntToARGBArray(colorInt)
}

fun hexToARGB(colorString: String, argbIn: IntArray) {
    val colorInt = hexToColorInt(colorString)
    colorIntToARGBArray(colorInt, argbIn)
}


fun hexToColor(colorString: String): Color {
    return Color(hexToColorInt(colorString))
}
