package com.example.testn96.landing

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.testn96.R

@Composable
fun ImageIntro(
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier.padding(start = 5.dp, end = 5.dp)) {
        Image(
            painter = painterResource(id = R.drawable.cardtapphone),
            contentDescription = "Background welcome",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.size(320.dp)
        )
    }
}

@Composable
fun ImageBackground(
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier.padding()) {
        Image(
            painter = painterResource(id = R.drawable.background_bienvenida),
            contentDescription = "Background welcome",
            contentScale = ContentScale.None,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true)
@Composable
fun ImageBGPreview() {
    ImageBackground()
}