package cl.multicaja.klapcomercio.signup.juridical.bankscreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.testn96.common.*

@Composable
fun JuridicalBankScreen(
    navigateBack: () -> Unit,
    navigateNextStep: () -> Unit,
    onWhatsappIntent: () -> Unit
) {
    val focusManager = LocalFocusManager.current
   /* val uiState = viewModel.viewState.value
    ErrorResponseSnackBar(
        visibility = viewModel.viewState.value.errorResponseSnackBar.show,
        title = stringResource(id = R.string.snack_bar_internet_disconnected_title),
        subTitle = stringResource(id = R.string.snack_bar_internet_disconnected_message)
    ) {
        viewModel.onTriggeredEvent(JuridicalBankContract.Event.HideErrorResponseSnackBar)
    }
    if (uiState.navigateToNextSignUpScreen) {
        LaunchedEffect(key1 = Unit) {
            navigateNextStep()
        }
    }
    LoadingScreen2(isLoading = uiState.showLoadingScreen)
    InternetSnackBar(visibility = viewModel.viewState.value.internetSnackBar.show)
    BackHandler {
        navigateBack()
    }*/
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        backgroundColor = Color.White,
        floatingActionButton = {
            WhatsappButton(
                onClick = {
                    //viewModel.onTriggeredEvent(JuridicalBankContract.Event.DialogWhatsappVisibility)
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
            Card(
                modifier = Modifier.wrapContentSize(),
                elevation = 6.dp
            ) {
                ConfirmButtonBorderForm(
                    modifier = Modifier
                        .padding(32.dp)
                        .fillMaxWidth(),
                    text = "Ir a compose 1",
                    enable = true
                ) {
                    navigateNextStep()
                   // viewModel.onTriggeredEvent(JuridicalBankContract.Event.GetSaveBankData)
                }
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
                    interactionSource = remember {
                        MutableInteractionSource()
                    }
                ) {
                    //viewModel.onTriggeredEvent(JuridicalBankContract.Event.HideAllDropDownList)
                    focusManager.clearFocus()
                }
        ) {
            val (subTitle, stepProgressBar, rut, legalOwnerName, email, autoCompleteBanks, dropDownListBanks, autocompleteAccountType, dropDownListAccountType, accountNumber) = createRefs()
            val banksFocusRequester = remember {
                FocusRequester()
            }
            val accountTypeFocusRequester = remember {
                FocusRequester()
            }
            DialogWhatsapp(
                show = false,
                onCloseClick = {
                   // viewModel.onTriggeredEvent(JuridicalBankContract.Event.DialogWhatsappVisibility)
                },
                onWhatsappClick = { onWhatsappIntent() }
            )
            ScreenSubTitle(
                modifier = Modifier
                    .padding(horizontal = 32.dp)
                    .constrainAs(subTitle) {
                        top.linkTo(parent.top, margin = 32.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                text = "Compose 3"
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
                currentStep = 3f
            )
            //rut
            InputTextRut(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .constrainAs(rut) {
                        top.linkTo(stepProgressBar.bottom, margin = 10.dp)
                    },
                onFieldChange = {},
                enable = false,
                label = "",
                value = "",
                trailingIconType = null

            )
            //legal owner name
            InputTextField(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .constrainAs(legalOwnerName) {
                        top.linkTo(rut.bottom, margin = 5.dp)
                    },
                onFieldTextChange = { },
                label = "",
                value = "",
                enable = false,
                trailingIconType = null
            )
            // email
            InputTextField(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .constrainAs(email) {
                        top.linkTo(legalOwnerName.bottom, margin = 5.dp)
                    },
                onFieldTextChange = { },
                label = "",
                value = "",
                enable = false,
                trailingIconType = null
            )
            //banks
            AutoCompleteTextField(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .onFocusChanged { focusState ->
                        if (focusState.hasFocus) {
                            /*viewModel.onTriggeredEvent(
                                JuridicalBankContract.Event.OnBanksShowIconClick(
                                    true
                                )
                            )*/
                        }
                    }
                    .focusRequester(banksFocusRequester)
                    .constrainAs(autoCompleteBanks) {
                        top.linkTo(email.bottom, margin = 10.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                enable = true,
                errorLabel = "",
                hint = "",
                isListVisible = false,
                selectedItem = "",
                readOnly = true,
                onValueChange = { item ->
                    //viewModel.onTriggeredEvent(JuridicalBankContract.Event.OnBanksSelectedItem(item))
                },
                onShowIconClick = { isShow ->
                    banksFocusRequester.requestFocus()
                   /* viewModel.onTriggeredEvent(
                        JuridicalBankContract.Event.OnBanksShowIconClick(
                            isShow
                        )
                    )*/
                }
            )
            AutoCompleteDropDownList(
                Modifier.padding(horizontal = 16.dp)
                    .constrainAs(dropDownListBanks) {
                    top.linkTo(autoCompleteBanks.bottom)
                },
                expanded = false,
                itemsList = emptyList(),
            ) { onExpandedChange, itemSelected ->
                /*viewModel.onTriggeredEvent(
                    JuridicalBankContract.Event.OnBanksSelectedItem(
                        itemSelected
                    )
                )
                viewModel.onTriggeredEvent(
                    JuridicalBankContract.Event.OnBanksShowIconClick(
                        onExpandedChange
                    )
                )*/
            }
            //account type
            AutoCompleteTextField(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .onFocusChanged { focusState ->
                        if (focusState.hasFocus) {
                           /* viewModel.onTriggeredEvent(
                                JuridicalBankContract.Event.OnAccountTypeShowIconClick(
                                    true
                                )
                            )*/
                        }
                    }
                    .focusRequester(accountTypeFocusRequester)
                    .constrainAs(autocompleteAccountType) {
                        top.linkTo(autoCompleteBanks.bottom, margin = 10.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                enable = true,
                errorLabel = "",
                hint = "",
                isListVisible = false,
                selectedItem = "",
                readOnly = true,
                onValueChange = { item ->

                },
                onShowIconClick = { isShow ->
                    accountTypeFocusRequester.requestFocus()

                }
            )
            AutoCompleteDropDownList(
                Modifier.padding(horizontal = 16.dp)
                    .constrainAs(dropDownListAccountType) {
                    top.linkTo(autocompleteAccountType.bottom)
                },
                expanded = false,
                itemsList = emptyList(),
            ) { onExpandedChange, itemSelected ->

            }
            //account number
            InputNumberField(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .constrainAs(accountNumber) {
                        top.linkTo(autocompleteAccountType.bottom, margin = 10.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                value = "",
                onFieldChange = { value ->

                },
                enable = true,
                label = "",
                trailingIconType = null,
                isError = false,
                maxLength = 18,
                paddingLabel = 16,
                errorLabel = "",
            )
        }
    }
}

@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true)
@Composable
fun JuridicalBankScreenPreview() {
    JuridicalBankScreen(
        navigateBack = {},
        navigateNextStep = {},
        onWhatsappIntent = {}
    )
}
