package com.example.testn96.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cl.multicaja.klapcomercio.signup.juridical.bankscreen.JuridicalBankScreen
import cl.multicaja.klapcomercio.signup.juridical.navigation.RoutesJuridical

@Composable
fun NavigationJuridical2(
    startDestination: String = RoutesJuridical.BankDataScreen.route,
    navigateFirstActivity: () -> Unit
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(RoutesJuridical.BankDataScreen.route) {
            JuridicalBankScreen(navigateBack = { navigateFirstActivity() }, navigateNextStep = { navigateFirstActivity() }) {

            }
        }

    }
}