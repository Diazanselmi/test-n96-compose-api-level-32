package com.example.testn96.common

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testn96.R


@Composable
fun AutoCompleteTextField(
    modifier: Modifier = Modifier,
    isListVisible: Boolean,
    selectedItem: String,
    isLoading: Boolean = false,
    enable: Boolean = false,
    readOnly: Boolean = false,
    errorLabel: String? = null,
    isError: Boolean = false,
    paddingLabel: Dp = 8.dp,
    hint: String = "",
    trailingIconType: String? = null,
    hintFontSize: TextUnit = TextUnit.Unspecified,
    ignoreRegex: Regex? = null,
    onValueChange: (String) -> Unit,
    onShowIconClick: (Boolean) -> Unit
) {
    var textFieldValueState by remember {
        mutableStateOf(
            TextFieldValue(
                text = selectedItem,
                selection = TextRange(selectedItem.length)
            )
        )
    }
    textFieldValueState = TextFieldValue(
        text = selectedItem,
        selection = TextRange(selectedItem.length)
    )
    val stateColor: Color = when {
        enable && !isError -> colorResource(id = R.color.sign_up_enable_field)
        enable && isError -> colorResource(id = R.color.sign_up_error_text)
        else -> colorResource(id = R.color.sign_up_disable_field)
    }
    val focusManager = LocalFocusManager.current
    // Category Field
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        OutlinedTextField(
            value = textFieldValueState,
            onValueChange = {
                if (ignoreRegex != null) {
                    if (!it.text.contains(ignoreRegex)) {
                        onValueChange(it.text)
                    }
                } else {
                    onValueChange(it.text)
                }
            },
            enabled = enable,
            readOnly = readOnly,
            isError = isError,
            label = { Text(text = hint, fontSize = hintFontSize) },
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
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    focusManager.clearFocus()
                }
            ),
            trailingIcon = {
                if (isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .width(24.dp)
                            .height(24.dp),
                        color = colorResource(id = R.color.colorAccent),
                        strokeWidth = 2.dp
                    )
                } else if (trailingIconType != null) {
                    TrailingIcon(
                        trailingIconType
                    )
                } else {
                    IconButton(
                        onClick = { onShowIconClick(!isListVisible) },
                        enabled = enable
                    ) {
                        Icon(
                            modifier = Modifier.size(24.dp),
                            imageVector = if (isListVisible) Icons.Filled.ArrowDropUp else Icons.Filled.ArrowDropDown,
                            contentDescription = "flecha hacia abajo para desplagar opciones",
                            tint = stateColor
                        )
                    }
                }
            }
        )
        AnimatedVisibility(
            visible = isError
        ) {
            if (isError) {
                Text(
                    modifier = modifier.padding(start = paddingLabel, top = 8.dp),
                    text = errorLabel ?: "",
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
fun AutoCompleteTextFieldPreview() {
    AutoCompleteTextField(
        isListVisible = false,
        selectedItem = "",
        errorLabel = "",
        isLoading = false,
        onValueChange = {},
        onShowIconClick = {}
    )
}

