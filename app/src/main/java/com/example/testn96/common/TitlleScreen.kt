package com.example.testn96.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.testn96.R

@Composable
fun ScreenTitle(
    modifier: Modifier = Modifier,
    text: String,
    size: TextUnit = 28.sp,
    position: Arrangement.Horizontal = Arrangement.Start
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = position
    ) {
        Text(text = text,
            style = TextStyle(
                fontSize = size,
                fontFamily = FontFamily(Font(R.font.montserrat_bold)),
                textAlign = TextAlign.Start,
                color = colorResource(id = R.color.colorPrimary)
            )
        )
    }
}

@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true)
@Composable
fun ScreenTitlePreview() {
    ScreenTitle(text = "Comienza tu registro Klap")
}