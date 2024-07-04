package com.example.testn96.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.testn96.legalagentscreen.ui.LegalAgentScreen
import cl.multicaja.klapcomercio.signup.juridical.navigation.RoutesJuridical
import com.example.testn96.welcomescreen.ui.WelcomeSignupScreen

@Composable
fun NavigationJuridical1(
    startDestination: String = RoutesJuridical.WelcomeScreen.route,
    navigateSecondActivity: () -> Unit
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(RoutesJuridical.WelcomeScreen.route) {
            WelcomeSignupScreen(
                navigateBack = {  },
                navigateLegalAgentStep = { navController.navigate(RoutesJuridical.LegalAgentScreen.route) },
                navigateIndividualStep = {

                },
                navigateLoginStep = {

                }, navigateSecondLoginStep = {

                }
            )
        }
        composable(RoutesJuridical.LegalAgentScreen.route) {
            LegalAgentScreen(
                navigateBack = { navController.navigate(RoutesJuridical.WelcomeScreen.route) },
                navigateNextStep = { navigateSecondActivity() },
                onWhatsappIntent = {  }
            )
        }

    }
}