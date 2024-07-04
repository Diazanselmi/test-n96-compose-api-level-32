package com.example.testn96.page

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun LoadingScreen(
    isLoading: Boolean,
    textLoading: String = "",
    content: @Composable () -> Unit
) {
    if (isLoading) {
        Surface(modifier = Modifier) {
            Surface(
                color = White,
                modifier = Modifier
                    .fillMaxSize()
                    .zIndex(1f)
            ) {
                Scaffold(modifier = Modifier.fillMaxSize(),
                    content = {
                        Row(
                            modifier = Modifier.fillMaxSize(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {


                        }
                    },
                    bottomBar = {
                        Row(
                            modifier = Modifier.padding(20.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(
                                modifier = Modifier.fillMaxWidth(),
                                text = textLoading.ifEmpty { "Procesando ...." },
                                fontSize = 18.sp,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                )
            }
            content()
        }
    } else {
        content()
    }
}

@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true)
@Composable
fun LoadingPreview() {
    LoadingScreen(
        isLoading = true,
        textLoading = "",
        content = {}
    )
}