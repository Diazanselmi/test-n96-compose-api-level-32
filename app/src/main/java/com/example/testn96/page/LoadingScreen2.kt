package cl.multicaja.klapcomercio.signup.common.composables.page

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
fun LoadingScreen2(
    isLoading: Boolean,
    textLoading: String = "",
) {
    if (isLoading) {
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
    }
}

@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true)
@Composable
fun LoadingPreview2() {
    LoadingScreen2(
        isLoading = true,
        textLoading = "",
    )
}