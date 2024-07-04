package com.example.testn96.common

import androidx.compose.animation.*
import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.testn96.R

@Composable
fun InternetSnackBar(modifier: Modifier = Modifier, visibility: Boolean) {
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
                .background(colorResource(id = R.color.sign_up_snack_bar), RectangleShape)
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(horizontal = 32.dp, vertical = 10.dp)
        ) {
            Row(modifier = Modifier) {
                Image(
                    modifier = modifier
                        .padding(end = 36.dp)
                        .align(Alignment.CenterVertically),
                    painter = painterResource(id = R.drawable.ic_sign_up_wifi_off),
                    contentDescription = "Sin wifi"
                )
                Column {
                    Text(
                        text = "Ha ocurrido un error",
                        textAlign = TextAlign.Start,
                        color = Color.White,
                        fontSize = 14.sp,
                        fontFamily = FontFamily(
                            Font(R.font.montserrat_semibold)
                        )
                    )
                    Text(
                        text = "En estos momentos no tienes conexión, conéctese a una red para usar la app.",
                        textAlign = TextAlign.Start,
                        color = Color.White,
                        fontSize = 12.sp,
                        fontFamily = FontFamily(
                            Font(R.font.montserrat_regular)
                        )
                    )
                }
            }
        }
    }
}

@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true)
@Composable
fun SignUpSnackBarPreview() {
    InternetSnackBar(visibility = true)
}