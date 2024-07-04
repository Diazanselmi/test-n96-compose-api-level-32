package com.example.testn96.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.offset
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.FloatingActionButtonDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.example.testn96.R
import kotlin.math.roundToInt

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun WhatsappButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    var offsetX by remember { mutableStateOf(0f) }
    var offsetY by remember { mutableStateOf(0f) }

    FloatingActionButton(
        modifier = modifier
            .offset { IntOffset(offsetX.roundToInt(), offsetY.roundToInt()) }
            .pointerInput(Unit) {
                detectDragGestures { change, dragAmount ->
                    change.consume()
                    offsetX += dragAmount.x
                    offsetY += dragAmount.y
                }
            },
        onClick = { onClick() },
        backgroundColor = Color.Transparent,
        elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 0.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.whatsapp_button),
            contentDescription = "bottón de ayuda en whatsapp",
            contentScale = ContentScale.FillBounds
        )
    }

}

@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true)
@Composable
fun WhatsappButtonPreview() {
    WhatsappButton {

    }
}