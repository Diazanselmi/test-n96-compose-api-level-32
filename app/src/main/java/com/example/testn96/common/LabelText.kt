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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.testn96.R

@Composable
fun LabelText(
    modifier: Modifier = Modifier,
    text: String,
    fontSize: TextUnit = 12.sp,
    position: Arrangement.Horizontal = Arrangement.Center,
    fontWeight: FontWeight = FontWeight.Light,
    fontFamily: FontFamily = FontFamily(Font(R.font.montserrat_regular)),
    textAlign: TextAlign = TextAlign.Left
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = position
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontSize = fontSize,
                fontFamily = fontFamily,
                textAlign = TextAlign.Justify,
                color = colorResource(id = R.color.gray_label_indicator),
                fontWeight = fontWeight,
            ),
            textAlign = textAlign
        )
    }
}

@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true)
@Composable
fun LabelTextPreview() {
    LabelText(text = "Para protegerte de fraudes y estafas, solicitamos el N° de documento, solo lo tienes tú")
}