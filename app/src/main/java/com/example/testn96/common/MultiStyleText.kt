package com.example.testn96.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testn96.R

@Composable
fun MultiStyleText(
    modifier: Modifier = Modifier,
    text1: String,
    secondaryColor: Color,
    text2: String,
    strongColor: Color,
    text3: String,
    textAlign: TextAlign = TextAlign.Justify
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 40.dp, end = 40.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        val spacer = " "
        Text(
            fontSize = 16.sp,
            fontFamily = FontFamily(Font(R.font.montserrat_regular)),
            textAlign = textAlign,
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(color = secondaryColor)) {
                    append(text1 + spacer)
                }
                withStyle(
                    style = SpanStyle(
                        color = strongColor,
                        fontFamily = FontFamily(Font(R.font.montserrat_bold))
                    )
                ) {
                    append(text2 + spacer)
                }
                withStyle(style = SpanStyle(color = secondaryColor)) {
                    append(text3)
                }
            }
        )
    }
}

@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true)
@Composable
fun MultiStyleTextPreview() {
    MultiStyleText(
        text1 = "Ingresa",
        secondaryColor = colorResource(id = R.color.darkBlack),
        text2 = "tu RUT de comercio",
        strongColor = colorResource(id = R.color.darkBlack),
        text3 = "de persona natural o jurídica para registrarte en Klap"
    )
}
