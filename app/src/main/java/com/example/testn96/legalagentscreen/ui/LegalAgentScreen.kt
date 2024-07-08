@file:Suppress("NAME_SHADOWING")

package com.example.testn96.legalagentscreen.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.DrawerValue
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.testn96.common.*

@Composable
fun LegalAgentScreen(
    navigateBack: () -> Unit,
    navigateNextStep: () -> Unit,
    onWhatsappIntent: () -> Unit
) {
    val focusManager = LocalFocusManager.current
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    /*val uiState = viewModel.viewState.value
    ErrorResponseSnackBar(
        visibility = uiState.errorResponseSnackBar.show,
        title = stringResource(id = R.string.snack_bar_internet_disconnected_title),
        subTitle = stringResource(id = R.string.snack_bar_internet_disconnected_message)
    ) {
        viewModel.onTriggeredEvent(LegalAgentContract.Event.HideErrorResponseSnackBar)
    }

    LoadingScreen2(
        isLoading = uiState.saveContactInfoService.isLoading,
        textLoading = stringResource(id = R.string.sign_up_progress_bar_message)
    )

    if (uiState.navigateToCommerceDataScreen) {
        LaunchedEffect(key1 = Unit) {
            navigateNextStep()
        }
    }

    if (uiState.promotionalCodeField.showMessage) {
        LaunchedEffect(key1 = Unit, block = {
            delay(3000)
            viewModel.onTriggeredEvent(LegalAgentContract.Event.ShowSnackBarMessage(false))
        })
    }

    BackHandler {
        navigateBack()
    }

    SuccessSnackBar(
        visibility = uiState.promotionalCodeField.showMessage,
        message = stringResource(id = R.string.personal_data_xml_promotional_code_alert_success)
    )

    InternetSnackBar(visibility = uiState.internetSnackBar.show)*/

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState,
        backgroundColor = Color.White,
        floatingActionButton = {
            WhatsappButton(
                onClick = {
                    //viewModel.onTriggeredEvent(LegalAgentContract.Event.DialogWhatsappVisibility)
                }
            )
        },
        topBar = {
            CustomTopAppBar(
                onArrowBackClick = {
                    navigateBack()
                }
            )
        },
        bottomBar = {
            ConfirmButtonBorderForm(
                modifier = Modifier
                    .padding(start = 30.dp, end = 30.dp, top = 30.dp, bottom = 20.dp)
                    .fillMaxWidth(),
                enable = true,
                textSize = 16,
                text = "Ir a compose 3"
            ) {
                focusManager.clearFocus(force = true)
                navigateNextStep()
            }
        }
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .verticalScroll(rememberScrollState())
                .clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() }) {
                    focusManager.clearFocus(force = true)
                }
        ) {
            val (title, subTitle, stepProgressBar, rut, documentNumber, labelIndicator, names, firstLastName,
                secondLastName, phone, email, promotionTitle, promotionalCode, checkAccept) = createRefs()

            val docNumberFocus = remember { FocusRequester() }
            val namesFocus = remember { FocusRequester() }
            val firstLastNameFocus = remember { FocusRequester() }
            val secondLastNameFocus = remember { FocusRequester() }
            val phoneFocus = remember { FocusRequester() }
            val emailFocus = remember { FocusRequester() }
            val promotionalCodeFocus = remember { FocusRequester() }
            val checkConditionFocus = remember { FocusRequester() }

            DialogWhatsapp(
                show = false,
                onCloseClick = {  },
                onWhatsappClick = { onWhatsappIntent() }
            )

            ScreenTitle(
                modifier = Modifier
                    .padding(horizontal = 32.dp)
                    .constrainAs(title) {
                        top.linkTo(parent.top, margin = 32.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                text = ""
            )

            ScreenSubTitle(
                modifier = Modifier
                    .padding(start = 32.dp, end = 32.dp, top = 15.dp)
                    .constrainAs(subTitle) {
                        top.linkTo(title.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                text = "Compose 2"
            )

            StepProgressBar(
                modifier = Modifier
                    .padding(horizontal = 32.dp)
                    .constrainAs(stepProgressBar) {
                        top.linkTo(subTitle.bottom, margin = 10.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                numberOfSteps = 6f,
                currentStep = 1f
            )

            InputTextRut(
                modifier = Modifier
                    .padding(start = 15.dp, end = 15.dp)
                    .constrainAs(rut) {
                        top.linkTo(stepProgressBar.bottom, margin = 10.dp)
                    },
                onFieldChange = { rutLegalAgent ->

                },
                label = "",
                paddingLabel = 15,
            )

            InputNumberField(
                modifier = Modifier
                    .padding(start = 15.dp, end = 15.dp)
                    .constrainAs(documentNumber) {
                        top.linkTo(rut.bottom, margin = 10.dp)
                    }
                    .focusRequester(docNumberFocus),
                onFieldChange = { docNumber ->

                },
                label = "",
                paddingLabel = 15,
            )

            LabelText(
                modifier = Modifier
                    .padding(start = 45.dp, end = 30.dp)
                    .constrainAs(labelIndicator) {
                        top.linkTo(documentNumber.bottom, margin = 10.dp)
                    },
                text = "",
            )

            InputTextField(
                modifier = Modifier
                    .padding(start = 15.dp, end = 15.dp)
                    .constrainAs(names) {
                        top.linkTo(labelIndicator.bottom, margin = 10.dp)
                    }
                    .focusRequester(namesFocus),
                onFieldTextChange = { names ->

                },
                label = "",
                paddingLabel = 15,
                maxLength = 30
            )

            InputTextField(
                modifier = Modifier
                    .padding(start = 15.dp, end = 15.dp)
                    .constrainAs(firstLastName) {
                        top.linkTo(names.bottom, margin = 10.dp)
                    }
                    .focusRequester(firstLastNameFocus),
                onFieldTextChange = { firstLastName ->

                },
                label = "",

                paddingLabel = 15,
                maxLength = 30
            )

            InputTextField(
                modifier = Modifier
                    .padding(start = 15.dp, end = 15.dp)
                    .constrainAs(secondLastName) {
                        top.linkTo(firstLastName.bottom, margin = 10.dp)
                    }
                    .focusRequester(secondLastNameFocus),
                onFieldTextChange = { secondLastName ->

                },
                label = "",

                paddingLabel = 15,
                maxLength = 30
            )

            InputNumberFieldWithMask(
                modifier = Modifier
                    .padding(start = 15.dp, end = 15.dp)
                    .constrainAs(phone) {
                        top.linkTo(secondLastName.bottom, margin = 10.dp)
                    }
                    .focusRequester(phoneFocus),
                onFieldChange = { phone ->

                },
                label = "",

                paddingLabel = 15,
            )


            InputTextFieldEmail(
                modifier = Modifier
                    .padding(start = 15.dp, end = 15.dp)
                    .constrainAs(email) {
                        top.linkTo(phone.bottom, margin = 10.dp)
                    }
                    .onFocusChanged { focus ->

                    }
                    .focusRequester(emailFocus),
                onFieldChange = { email ->

                },
                label = "",
                paddingLabel = 15
            )

            PromotionalCodeTitle(modifier = Modifier
                .padding(start = 30.dp, top = 10.dp)
                .constrainAs(promotionTitle) {
                    top.linkTo(email.bottom, margin = 8.dp)
                })

            InputTextFieldWithButton(
                modifier = Modifier
                    .padding(start = 15.dp, end = 15.dp)
                    .constrainAs(promotionalCode) {
                        top.linkTo(promotionTitle.bottom, margin = 10.dp)
                    }
                    .focusRequester(promotionalCodeFocus),
                onFieldChange = { promotionalCode ->

                },
                label = "",

                paddingLabel = 15,

            )

            CheckboxWithLabel(
                modifier = Modifier
                    .padding(start = 15.dp, end = 30.dp, top = 20.dp)
                    .constrainAs(checkAccept) {
                        top.linkTo(promotionalCode.bottom)
                    }
                    .focusRequester(checkConditionFocus),
                checked = false,
                onCheckedChange = { checkedState ->

                    focusManager.clearFocus(force = true)
                },
                label = "",
            )
        }
    }

}


