package com.example.testn96.common

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.testn96.R

@Composable
fun PromotionalCodeTitle(modifier: Modifier = Modifier) {
    Text(
        modifier= modifier,
        text = "¿Tienes un código promocional?",
        style = TextStyle(
            fontSize = 16.sp,
            fontFamily = FontFamily(Font(R.font.montserrat_semibold)),
            textAlign = TextAlign.Start,
            color = colorResource(id = R.color.colorPrimary)
        )
    )
}

@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true)
@Composable
fun PromotionalCodeTitlePreview() {
    PromotionalCodeTitle()
}
