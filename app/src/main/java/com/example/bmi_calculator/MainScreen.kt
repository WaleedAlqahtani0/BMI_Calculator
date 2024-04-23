package com.example.bmi_calculator


import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bmi_calculator.ui.theme.Purple80
import java.math.RoundingMode
import java.text.DecimalFormat



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel
) {
    val state = viewModel.state
    val weight = state.weight
    val height = state.height
    val bmi = state.BMI
    val lWeight = state.lowerWeightBound
    val hWeight = state.higherWeightBound
    val context = LocalContext.current
    val category = state.category
    val df = DecimalFormat("#.#")
    df.roundingMode = RoundingMode.CEILING

// --- introdation
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(Modifier.padding(vertical = 16.dp),
            contentAlignment = Alignment.Center) {
            Text(
                text = "Calculate BMI",
                color = White,
                fontSize = 28.sp,
                fontWeight = Bold,
            )
        }

        // Circular Progress bar
        Box(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 16.dp)
                .size(200.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = if (bmi > 100) ">100" else df.format(bmi.toBigDecimal()),
                color = Color.White,
                fontSize = 48.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Medium,
            )
            CircularProgressIndicator(
                progress = getProgress(bmi),
                color = category.color,
                strokeWidth = 16.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
            )
        }

        // space under the title
        Divider(modifier = Modifier.fillMaxWidth())
        Row(
            verticalAlignment = Alignment.Bottom
        ) {

            // check is there anything not number
            TextField(modifier = Modifier.background(Color.Black),
                value = height,
                onValueChange = {
                    if (state.height.isBlank() && it == ".") {
                        Toast.makeText(
                            context, "Error", Toast.LENGTH_LONG
                        ).show()
                    } else
                        viewModel.changeHeight(it)
                },
                textStyle = TextStyle(
                    fontSize = 14.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                ),
                label = {
                    Text(
                        text = "Height",
                        color = Color.White,

                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Green,
                    unfocusedIndicatorColor = Color.White,
                   containerColor = Color.Black
                )
            )
            Spacer(
                modifier = Modifier.width(6.dp)
            )
            Text(
                text = "cm",
                fontSize = 14.sp,
                color = Color.White,
                fontWeight = FontWeight.Light
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
        Row(verticalAlignment = Alignment.Bottom) {
            TextField(
                value = weight,
                onValueChange = {
                    if (state.weight.isBlank() && it == ".") {
                        Toast.makeText(
                            context, "Error", Toast.LENGTH_LONG
                        ).show()
                    } else
                        viewModel.changeWeight(it)
                },
                textStyle = TextStyle(
                    fontSize = 14.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                ),
                label = {
                    Text(
                        "Weight",
                        color = Color.White
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Green,
                    unfocusedIndicatorColor = Color.White,
                    containerColor = Color.Black
                )
            )
            Spacer(
                modifier = Modifier.width(6.dp)
            )
            Text(
                text = "kg",
                fontSize = 14.sp,
                color = Color.White,
                fontWeight = FontWeight.Light
            )
        }


        Spacer(modifier = Modifier.height(32.dp))
        Box(contentAlignment = Alignment.Center) {
            Text(
                text = category.name,
                color = category.color,
                fontSize = 24.sp,
                fontWeight = FontWeight.Medium
            )
        }
        Divider(modifier = Modifier.fillMaxWidth())
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            BmiChart(
                text = "Underweight",
                text2 = "Normal Weight",
                text3 = "Overweight",
                text4 = "Obese Class I",
                text5 = "Obese Class II",
                text6 = "Obese Class III",
                size = 14.sp,
                fontWeight = FontWeight.Light,
                alignment = Alignment.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp)
                    .weight(1f)
                    .fillMaxHeight(0.8f)
            )

            BmiChart(
                text = "<=18.5",
                text2 = "18.5 - 24.9",
                text3 = "25 - 29.9",
                text4 = "30 - 34.9",
                text5 = "35 - 39.9",
                text6 = ">=40",
                size = 14.sp,
                fontWeight = FontWeight.Bold,
                alignment = Alignment.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .weight(1f)
                    .fillMaxHeight(0.8f)
            )
        }
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Text(
                "Normal Weight",
                fontSize = 20.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            Text(
                "${lWeight.toInt()} - ${hWeight.toInt()} kg",
                fontSize = 20.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )


        }

    }
}

fun getProgress(
    bmi: Float
): Float {
    var progress = 0f
    if (bmi == 0f) {
        progress = 0f
    } else if (bmi < 18.5) {
        progress = .1f
    } else if (bmi >= 18.5 && bmi < 24.9) {
        progress = .5f
    } else if (bmi >= 24.9 && bmi < 30) {
        progress = .75f
    } else if (bmi >= 30) {
        progress = 1f
    }
    return progress
}