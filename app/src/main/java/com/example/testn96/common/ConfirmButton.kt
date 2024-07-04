package com.example.testn96.common

import androidx.annotation.ColorRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testn96.R

@Composable
fun ConfirmButton(
    modifier: Modifier = Modifier,
    text: String,
    enable: Boolean = false,
    textSize: Int = 16,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier,
        elevation = ButtonDefaults.elevation(6.dp),
        enabled = enable,
        shape = RoundedCornerShape(corner = CornerSize(25.dp)),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = colorResource(
                id = R.color.colorAccent
            ),
            contentColor = colorResource(
                id = R.color.white
            ),
            disabledBackgroundColor = colorResource(
                id = R.color.grey
            ),
            disabledContentColor = colorResource(
                id = R.color.white
            )
        ),
        onClick = { onClick() }) {
        Text(
            text = text,
            style = TextStyle(
                fontSize = textSize.sp,
                fontFamily = FontFamily(Font(R.font.montserrat_bold)),
            )
        )
    }
}

@Composable
fun ConfirmButtonBorderForm(
    modifier: Modifier = Modifier,
    text: String,
    enable: Boolean = false,
    textSize: Int = 16,
    @ColorRes backgroundColor: Int = R.color.colorAccent,
    @ColorRes contentColor: Int = R.color.white,
    @ColorRes borderColor: Int = R.color.transparent,
    elevation: Dp = 6.dp,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier,
        elevation = ButtonDefaults.elevation(elevation),
        enabled = enable,
        shape = RoundedCornerShape(corner = CornerSize(10.dp)),
        border = BorderStroke(0.5.dp, color = colorResource(id = borderColor)),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = colorResource(
                id = backgroundColor
            ),
            contentColor = colorResource(
                id = contentColor
            ),
            disabledBackgroundColor = colorResource(
                id = R.color.gray_disable2
            ),
            disabledContentColor = colorResource(
                id = R.color.gray_label_indicator
            )
        ),
        onClick = { onClick() }) {
        Text(
            text = text,
            style = TextStyle(
                fontSize = textSize.sp,
                fontFamily = FontFamily(Font(R.font.montserrat_bold)),
            )
        )
    }
}

@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true)
@Composable
fun ConfirmButtonPreview() {
    ConfirmButtonBorderForm(text = "CONTINUAR") {
    }
}