package com.example.testn96.common


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.testn96.R

@Composable
fun DialogWhatsapp(
    modifier: Modifier = Modifier,
    show: Boolean = false,
    tile: String = stringResource(id = R.string.sign_up_dialog_whatsapp_title),
    message: String = stringResource(id = R.string.sign_up_dialog_whatsapp_massage),
    buttonText: String = stringResource(id = R.string.sign_up_dialog_whatsapp_btn_text),
    onCloseClick: () -> Unit,
    onWhatsappClick: () -> Unit
) {
    if (show) {
        Dialog(onDismissRequest = { }) {
            Card(
                shape = RoundedCornerShape(10.dp),
                modifier = modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                backgroundColor = colorResource(id = R.color.lightGrey),
                elevation = 8.dp
            ) {
                Column(
                    modifier = modifier.padding(
                        start = 8.dp,
                        end = 8.dp,
                        top = 8.dp,
                        bottom = 32.dp
                    )
                ) {
                    Image(
                        painterResource(id = R.drawable.baseline_close_24),
                        contentDescription = stringResource(id = R.string.sign_up_dialog_whatsapp_close_icon_description),
                        modifier = Modifier
                            .padding(top = 4.dp, end = 16.dp)
                            .size(24.dp)
                            .align(Alignment.End)
                            .clickable { onCloseClick() }
                    )
                    Text(
                        text = tile,
                        textAlign = TextAlign.Center,
                        color = colorResource(id = R.color.colorPrimary),
                        modifier = modifier
                            .padding(top = 5.dp, start = 16.dp, end = 16.dp)
                            .align(Alignment.CenterHorizontally),
                        style = TextStyle(
                            fontFamily = FontFamily(Font(R.font.montserrat_bold)),
                            fontSize = 16.sp
                        ),
                        overflow = TextOverflow.Ellipsis
                    )
                    Spacer(modifier = modifier.padding(vertical = 8.dp))
                    Text(
                        text = message,
                        textAlign = TextAlign.Center,
                        color = colorResource(id = R.color.colorPrimary),
                        modifier = modifier
                            .padding(top = 5.dp, start = 16.dp, end = 16.dp)
                            .align(Alignment.CenterHorizontally),
                        fontSize = 14.sp,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                    Spacer(modifier = Modifier.padding(vertical = 16.dp))
                    ConfirmButtonBorderForm(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                            .align(Alignment.CenterHorizontally),
                        text = buttonText,
                        enable = true,
                        textSize = 14
                    ) {
                        onWhatsappClick()
                    }
                }
            }
        }
    }
}

@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true)
@Composable
fun DialogSendEmailPreview() {
    DialogWhatsapp(
        show = true,
        onCloseClick = {},
        onWhatsappClick = {}
    )
}