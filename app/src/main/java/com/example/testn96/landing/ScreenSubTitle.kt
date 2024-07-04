package com.example.testn96.landing

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
fun ScreenSubTitlePrimary(
    modifier: Modifier = Modifier,
    text: String
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontSize = 24.sp,
                textAlign = TextAlign.Center,
                color = colorResource(id = R.color.colorPrimary),
                fontFamily = FontFamily(Font(R.font.montserrat_semibold))
            )
        )
    }
}

@Composable
fun ScreenSubTitleSuccess(
    modifier: Modifier = Modifier,
    text: String
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                color = colorResource(id = R.color.colorAccentBorder),
                fontFamily = FontFamily(Font(R.font.montserrat_bold))
            )
        )
    }
}

@Composable
fun ScreenSubTitleDescription(
    modifier: Modifier = Modifier,
    text: String
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 40.dp, end = 40.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontSize = 16.sp,
                textAlign = TextAlign.Justify,
                color = colorResource(id = R.color.black),
                fontFamily = FontFamily(Font(R.font.montserrat_regular))
            )
        )
    }
}

@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true)
@Composable
fun ScreenSubTitleDescription() {
    ScreenSubTitleDescription(text = "Ingresa tu RUT de comercio de persona natural o jurídica para registrarte en Klap")
}