package com.example.bmi_calculator


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.TextUnit



@Composable
fun BmiChart(
    modifier: Modifier = Modifier,
    text: String,
    text2: String,
    text3: String,
    text4: String,
    text5:String,
    text6:String,
    size:TextUnit,
    fontWeight: FontWeight,
    alignment: Alignment.Horizontal
){
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = alignment
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontSize = size,
                fontWeight = fontWeight,
                color = Color.White
            )
        )
        Text(
            text = text2,
            style = TextStyle(
                fontSize = size,
                fontWeight = fontWeight,
                color = Color.White
            )
        )

        Text(
            text = text3,
            style = TextStyle(
                fontSize = size,
                fontWeight = fontWeight,
                color = Color.White
            )
        )
        Text(
            text = text4,
            style = TextStyle(
                fontSize = size,
                fontWeight = fontWeight,
                color = Color.White
            )
        )

        Text(
            text = text5,
            style = TextStyle(
                fontSize = size,
                fontWeight = fontWeight,
                color = Color.White
            )
        )

        Text(
            text = text6,
            style = TextStyle(
                fontSize = size,
                fontWeight = fontWeight,
                color = Color.White
            )
        )
    }
}