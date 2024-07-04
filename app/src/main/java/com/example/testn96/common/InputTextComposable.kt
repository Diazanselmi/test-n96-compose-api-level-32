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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testn96.R

@Composable
fun InputTextField(
    modifier: Modifier = Modifier,
    onFieldTextChange: (String) -> Unit,
    label: String,
    labelFontSize: TextUnit = TextUnit.Unspecified,
    value: String = "",
    enable: Boolean = true,
    isError: Boolean = false,
    errorLabel: String? = null,
    paddingLabel: Int = 5,
    trailingIconType: String? = null,
    maxLength: Int = 9,
    imeAction: ImeAction = ImeAction.Next,
    ignoreRegex: Regex? = null
) {
    val focusManager = LocalFocusManager.current
    Column(modifier = modifier.fillMaxWidth()) {
        OutlinedTextField(
            value = value,
            onValueChange = {
              if (it.length <= maxLength) {
                  if (ignoreRegex != null) {
                      if (!it.contains(ignoreRegex)) onFieldTextChange(it)
                  } else {
                      onFieldTextChange(it)
                  }
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
            shape = RoundedCornerShape(corner = CornerSize(10.dp)),
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(
                autoCorrect = false,
                keyboardType = KeyboardType.Text,
                imeAction = imeAction
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    focusManager.clearFocus()
                }
            )
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