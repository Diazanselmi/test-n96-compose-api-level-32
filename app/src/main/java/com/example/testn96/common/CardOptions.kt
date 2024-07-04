package com.example.testn96.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testn96.R

@Composable
fun DocsCard(
    modifier: Modifier = Modifier,
    text: String,
    enable: Boolean = false,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Top
    ) {
        Card(
            shape = RoundedCornerShape(10.dp),
            elevation = 5.dp,
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
                .clickable {
                    if (enable) {
                        onClick()
                    }
                }
        ) {
            Row(
                modifier = Modifier.padding(
                    start = 10.dp,
                    top = 10.dp,
                    bottom = 10.dp,
                    end = 20.dp
                ),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = text,
                    modifier = Modifier.padding(10.dp),
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.montserrat_regular))
                )

                Image(
                    painter = painterResource(id = R.drawable.ic_preview_icon),
                    contentDescription = "show eye icon"
                )
            }
        }
    }
}

@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true)
@Composable
fun DocsCardPreview() {
    DocsCard(
        text = "Terminos y condiciones"
    ) {}
}