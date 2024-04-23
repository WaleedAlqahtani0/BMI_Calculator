package com.example.bmi_calculator

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.Yellow


enum class Category(val color: Color) {
    Underweight(Blue),
    Normal(Green),
    Overweight(Yellow),
    Obese(Red),
}