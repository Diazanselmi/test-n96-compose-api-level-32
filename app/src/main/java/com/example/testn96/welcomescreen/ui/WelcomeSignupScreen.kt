package com.example.testn96.welcomescreen.ui

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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.testn96.common.ButtonLink
import com.example.testn96.common.ConfirmButtonBorderForm
import com.example.testn96.common.InputTextRut
import com.example.testn96.landing.*

@Composable
fun WelcomeSignupScreen(
    navigateBack: () -> Unit,
    navigateLegalAgentStep: () -> Unit,
    navigateLoginStep: () -> Unit,
    navigateIndividualStep: () -> Unit,
    navigateSecondLoginStep: () -> Unit
) {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    val focusManager = LocalFocusManager.current
    /*val uiState = viewModel.viewState.value
    if (uiState.navigateToLegalAgentScreen) {
        LaunchedEffect(key1 = Unit) {
            navigateLegalAgentStep()
        }
    }
    if (uiState.navigateToIndividualScreen) {
        LaunchedEffect(key1 = Unit) {
            navigateIndividualStep()
        }
    }
    if (uiState.navigateToLoginScreen) {
        LaunchedEffect(key1 = Unit) {
            viewModel.onTriggeredEvent(
                RegisterRutContract.Event.GotoFirstLogin(false)
            )
            navigateLoginStep()
        }
    }
    if (uiState.navigateToSecondLoginScreen) {
        LaunchedEffect(key1 = Unit) {
            navigateSecondLoginStep()
        }
    }
    BackHandler {
        navigateBack()
    }

    ErrorResponseSnackBar(
        visibility = uiState.errorResponseSnackBar.show,
        title = stringResource(id = R.string.snack_bar_internet_disconnected_title),
        subTitle = stringResource(id = R.string.snack_bar_internet_disconnected_message)
    ) {
        viewModel.onTriggeredEvent(RegisterRutContract.Event.HideErrorResponseSnackBar)
    }

    LoadingScreen2(
        isLoading = uiState.checkCommerce.isLoading,
        textLoading = stringResource(id = R.string.sign_up_progress_bar_message)
    )

    InternetSnackBar(visibility = uiState.internetSnackBar.show)*/

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState,
        backgroundColor = Color.White,
        topBar = {},
        bottomBar = {

        },
        content = {
            ConstraintLayout(
                Modifier
                    .fillMaxSize()
                    .padding(it)
                    .verticalScroll(rememberScrollState())
                    .clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() }) {
                        focusManager.clearFocus(force = true)
                    }
            ) {
                val (titleScreen, imageWelcome, subtitleLine1, subtitleLine2, description, inputRut, continueBtn, loginLinkBtn) = createRefs()
                val topGuide = createGuidelineFromTop(0.05f)

                ImageBackground(Modifier.fillMaxSize())
                HeaderWithLogo(
                    Modifier
                        .constrainAs(titleScreen) {
                            top.linkTo(topGuide)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }, text = ""
                )

                ImageIntro(Modifier
                    .constrainAs(imageWelcome) {
                        top.linkTo(titleScreen.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)

                    })

                ScreenSubTitlePrimary(
                    Modifier
                        .constrainAs(subtitleLine1) {
                            top.linkTo(imageWelcome.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        },
                    text = ""
                )

                ScreenSubTitleSuccess(
                    Modifier
                        .constrainAs(subtitleLine2) {
                            top.linkTo(
                                subtitleLine1.bottom
                            )
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        },
                    text = "",
                )



                InputTextRut(
                    modifier = Modifier
                        .padding(start = 25.dp, end = 25.dp)
                        .fillMaxWidth()
                        .constrainAs(inputRut) {
                            top.linkTo(description.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        },
                    onFieldChange = { rut ->
                        //viewModel.onTriggeredEvent(RegisterRutContract.Event.ValidFormOnChange(rut))
                    },
                    value = "",
                    label = "",
                    enable = true,
                    errorLabel = "",
                    paddingLabel = 30
                )

                ConfirmButtonBorderForm(
                    modifier = Modifier
                        .padding(start = 50.dp, end = 50.dp, top = 20.dp)
                        .fillMaxWidth()
                        .constrainAs(continueBtn) {
                            top.linkTo(inputRut.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        },
                    enable = true,
                    textSize = 16,
                    text = "Ir a segundo compose"
                ) {
                    focusManager.clearFocus()
                   navigateLegalAgentStep()
                }

                ButtonLink(
                    modifier = Modifier
                        .padding(top = 20.dp, bottom = 10.dp)
                        .fillMaxWidth()
                        .constrainAs(loginLinkBtn) {
                            top.linkTo(continueBtn.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        },
                    fontSize = 16.sp,
                    text = "",
                    enable = true
                ) {

                }
            }
        }
    )
}

