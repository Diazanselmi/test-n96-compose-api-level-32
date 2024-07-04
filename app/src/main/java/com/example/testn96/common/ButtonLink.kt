package com.example.testn96.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.testn96.R

@Composable
fun ButtonLink(
    modifier: Modifier = Modifier,
    text: String,
    fontSize: TextUnit = 16.sp,
    enable: Boolean = true,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        val textButton = buildAnnotatedString {
            append(text)
        }

        ClickableText(
            text = textButton,
            style = TextStyle(
                textDecoration = TextDecoration.Underline,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily(Font(R.font.montserrat_regular)),
                color = colorResource(id = R.color.darkBlack),
                fontSize = fontSize
            ),
            onClick = {
                if (enable)
                    onClick()
            }
        )
    }
}

@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true)
@Composable
fun ButtonLinkPreview() {
    ButtonLink(text = "Iniciar sesión", onClick = {})
}