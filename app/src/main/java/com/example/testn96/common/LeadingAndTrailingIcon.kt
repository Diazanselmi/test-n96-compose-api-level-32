package com.example.testn96.common

import androidx.compose.foundation.Image
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.example.testn96.R

@Composable
fun TrailingIcon(trailingIconType: String) {
    IconPainter(R.drawable.ic_baseline_check_circle_24, "icon check")
}

@Composable
fun LeadingIcon(leadingIconType: String) {
     Text(text = "+56")


}

@Composable
private fun IconPainter(drawableId: Int, contentDescription: String) {
    Image(
        painter = painterResource(id = drawableId),
        contentDescription = contentDescription
    )
}

