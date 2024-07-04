package com.example.testn96.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testn96.R


@Composable
fun StepProgressBar(modifier: Modifier = Modifier, numberOfSteps: Float, currentStep: Float) {
    Column(modifier) {
        val backgroundWeight = (1 - (currentStep / numberOfSteps))
        Text(
            modifier = Modifier,
            text = "Paso ${currentStep.toInt()} de ${numberOfSteps.toInt()}",
            style = TextStyle(
                fontSize = 12.sp,
                fontFamily = FontFamily(Font(R.font.montserrat_semibold)),
                textAlign = TextAlign.Start,
                color = colorResource(id = R.color.colorPrimary)
            )
        )
        Row(
            modifier = Modifier
                .background(color = colorResource(id = R.color.stepBackground))
                .clip(
                    RoundedCornerShape(
                        topStart = 15.dp,
                        topEnd = 15.dp,
                        bottomStart = 15.dp,
                        bottomEnd = 15.dp
                    )
                )
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .clip(
                        RoundedCornerShape(
                            topStart = 15.dp,
                            topEnd = 15.dp,
                            bottomStart = 15.dp,
                            bottomEnd = 15.dp
                        )
                    )
                    .background(color = colorResource(id = R.color.stepColor))
                    .height(10.dp)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth(backgroundWeight)
                    .clip(
                        RoundedCornerShape(
                            topStart = 0.dp,
                            topEnd = 15.dp,
                            bottomStart = 0.dp,
                            bottomEnd = 15.dp
                        )
                    )
                    .background(color = colorResource(id = R.color.stepBackground))
                    .height(10.dp)
            )

        }
    }
}

@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true)
@Composable
fun StepProgressBarPreview() {
    StepProgressBar(modifier = Modifier.padding(20.dp), numberOfSteps = 6f, currentStep = 1f)
}