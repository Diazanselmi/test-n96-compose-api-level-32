package com.example.testn96.common

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.testn96.R

@Composable
fun SuccessSnackBar(
    modifier: Modifier = Modifier,
    visibility: Boolean,
    message: String = "Title"
) {
    val density = LocalDensity.current
    AnimatedVisibility(
        modifier = modifier
            .zIndex(1f),
        visible = visibility,
        enter = slideInVertically {
            with(density) { 0.dp.roundToPx() }
        } + expandVertically(),
        exit = slideOutVertically { with(density) { 0.dp.roundToPx() } } + shrinkVertically()
    ) {
        Box(
            modifier = modifier
                .background(colorResource(id = R.color.colorAccent), RectangleShape)
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(vertical = 20.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
            ) {
                Text(
                    text = message,
                    color = Color.White,
                    fontSize = 14.sp,
                    fontFamily = FontFamily(
                        Font(R.font.montserrat_semibold)
                    )
                )
            }
        }
    }
}

@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true)
@Composable
fun SuccessSnackBarPreview() {
    SuccessSnackBar(
        visibility = true,
        message = "Código ingresado correctamente."
    )
}