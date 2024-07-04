package com.example.testn96.landing

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testn96.R

@Composable
fun HeaderWithLogo(
    modifier: Modifier = Modifier,
    text: String
) {
    Row(
        modifier = modifier.padding(start = 5.dp, end = 5.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = Modifier.padding(start = 10.dp, end = 10.dp),
            text = text,
            style = TextStyle(
                fontSize = 24.sp,
                color = colorResource(id = R.color.lightBlack),
                fontFamily = FontFamily(Font(R.font.montserrat_semibold)),
            ),
            textAlign = TextAlign.Center
        )
        Image(
            painter = painterResource(id = R.drawable.dialog_update_device_id_warning),
            contentDescription = "icon blue phone",
            modifier = Modifier.size(110.dp),
            contentScale = ContentScale.Fit
        )
    }
}

@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true)
@Composable
fun HeaderPreview() {
    HeaderWithLogo(text = "Bienvenido a ")
}