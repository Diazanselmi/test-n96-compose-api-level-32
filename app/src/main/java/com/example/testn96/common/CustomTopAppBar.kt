package com.example.testn96.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.testn96.R

@Composable
fun CustomTopAppBar(
    modifier: Modifier = Modifier,
    enableArrowBackButton: Boolean = true,
    enableMenuButton: Boolean = false,
    onArrowBackClick: () -> Unit
) {
    TopAppBar(
        modifier = modifier
            .fillMaxWidth(),
        backgroundColor = colorResource(id = R.color.colorPrimary),
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(onClick = { onArrowBackClick() }, enabled = enableArrowBackButton) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "botón flecha atrás ",
                    tint = if (enableArrowBackButton) Color.White else colorResource(id = R.color.colorPrimary)
                )
            }
            Image(
                painter = painterResource(id = R.drawable.ic_klap_logo_menu),
                contentDescription = "klap logo",
                contentScale = ContentScale.Crop
            )
            IconButton(
                onClick = { },
                enabled = enableMenuButton) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "menu",
                    tint = if (enableMenuButton) Color.White else colorResource(id = R.color.colorPrimary)
                )
            }
        }
    }
}

@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true)
@Composable
fun CustomTopAppBarPreview() {
    CustomTopAppBar(
        enableArrowBackButton = true,
        enableMenuButton = false
    ) {

    }
}
