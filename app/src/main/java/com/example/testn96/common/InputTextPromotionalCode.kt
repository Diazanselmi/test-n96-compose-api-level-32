package com.example.testn96.common

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testn96.R

@Composable
fun InputTextFieldWithButton(
    modifier: Modifier = Modifier,
    onFieldChange: (String) -> Unit,
    label: String,
    value: String = "",
    enable: Boolean = true,
    isError: Boolean = false,
    errorLabel: String? = null,
    paddingLabel: Int = 5,
    trailingIcons: @Composable() (() -> Unit)? = null,
    imeAction: ImeAction = ImeAction.Next,
    maxLength: Int = 13
) {
    Column(modifier = modifier.fillMaxWidth()) {
        OutlinedTextField(
            value = value,
            onValueChange = {
                if (it.length <= maxLength) {
                    onFieldChange(it)
                }
            },
            enabled = enable,
            isError = isError,
            label = { Text(text = label) },
            trailingIcon = {
                if (trailingIcons != null) {
                    trailingIcons.invoke()
                }
            },
            modifier = modifier.fillMaxWidth(),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.DarkGray,
                unfocusedBorderColor = Color.Gray,
                errorBorderColor = colorResource(id = R.color.red_alert)
            ),
            shape = RoundedCornerShape(corner = CornerSize(10.dp)),
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(
                autoCorrect = false,
                keyboardType = KeyboardType.Text,
                imeAction = imeAction
            )
        )
        AnimatedVisibility(
            visible = errorLabel != null && isError
        ) {
            if (errorLabel != null) {
                Text(
                    modifier = Modifier.padding(start = paddingLabel.dp, top = 8.dp),
                    text = errorLabel,
                    fontFamily = FontFamily(Font(R.font.montserrat_regular)),
                    color = colorResource(id = R.color.red_alert),
                    fontSize = 12.sp
                )
            }
        }
    }
}


@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true)
@Composable
fun TextFieldPreview() {
    InputTextFieldWithButton(
        onFieldChange = { },
        label = "Codigo promocional",
        isError = true,
        errorLabel = "Dato ingresado no es valido"
    )
}