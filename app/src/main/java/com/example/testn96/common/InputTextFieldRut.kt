package com.example.testn96.common

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cl.multicaja.klapcomercio.signup.juridical.welcomescreen.util.MaskRutVisualTransformation
import com.example.testn96.R

object RutFormats {
    const val RUT_MASK_LARGE = "##.###.###-#"
    const val RUT_MASK_SHORT = "#.###.###-#"
    const val RUT_MAX_LENGTH = 9
}

@Composable
fun InputTextRut(
    modifier: Modifier = Modifier,
    onFieldChange: (String) -> Unit,
    value: String = "",
    label: String,
    enable: Boolean = true,
    isError: Boolean = false,
    errorLabel: String? = null,
    labelFontSize: TextUnit = TextUnit.Unspecified,
    paddingLabel: Int = 5,
    imeAction: ImeAction = ImeAction.Next,
    trailingIconType: String? = null
) {
    val focusManager = LocalFocusManager.current
    var rutFormat by remember { mutableStateOf(value) }
    val formatMask by remember(rutFormat) { mutableStateOf(getFormatMask(rutFormat)) }
    if (value != rutFormat) {
        rutFormat = value
    }

    Column(modifier = modifier.fillMaxWidth()) {
        OutlinedTextField(
            value = rutFormat,
            onValueChange = { newRut ->
                if (newRut.isEmpty() || (newRut.length <= RutFormats.RUT_MAX_LENGTH && isAllowedCharactersForRut(
                        newRut
                    ))
                ) {
                    rutFormat = newRut
                    onFieldChange(newRut)
                }
            },
            enabled = enable,
            isError = isError,
            label = { Text(text = label, fontSize = labelFontSize) },
            modifier = modifier.fillMaxWidth(),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.DarkGray,
                unfocusedBorderColor = Color.Gray,
                errorBorderColor = colorResource(id = R.color.red_alert)
            ),
            trailingIcon = { trailingIconType?.let { trailingIconType -> TrailingIcon(trailingIconType) } },
            singleLine = true,
            shape = RoundedCornerShape(corner = CornerSize(10.dp)),
            visualTransformation = MaskRutVisualTransformation(formatMask),
            keyboardOptions = KeyboardOptions.Default.copy(
                autoCorrect = false,
                keyboardType = KeyboardType.Text,
                imeAction = imeAction
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    focusManager.clearFocus(force = true)
                }
            ),
        )

        DisplayError(isError, errorLabel, paddingLabel)
    }
}

@Composable
private fun DisplayError(isError: Boolean, errorLabel: String?, paddingLabel: Int) {
    AnimatedVisibility(visible = isError && errorLabel != null) {
        Text(
            modifier = Modifier.padding(start = paddingLabel.dp, top = 8.dp),
            text = errorLabel ?: "",
            fontFamily = FontFamily(Font(R.font.montserrat_regular)),
            color = colorResource(id = R.color.red_alert),
            fontSize = 12.sp
        )
    }
}


private fun getFormatMask(value: String): String {
    return if (value.length < RutFormats.RUT_MAX_LENGTH) RutFormats.RUT_MASK_SHORT else RutFormats.RUT_MASK_LARGE
}

private fun isAllowedCharactersForRut(input: String): Boolean {
    val regex = Regex("^[0-9kK]+$")
    return regex.matches(input)
}

@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true)
@Composable
fun InputTextFieldHintPreview() {
    InputTextRut(
        onFieldChange = { },
        label = "RUT",
        isError = true,
        errorLabel = "RUT inválido.",
        trailingIconType = null
    )
}