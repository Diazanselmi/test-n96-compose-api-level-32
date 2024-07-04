package cl.multicaja.klapcomercio.signup.juridical.navigation

sealed class RoutesJuridical(val route: String) {

    object WelcomeScreen : RoutesJuridical(NavigationSteps.WelcomeStep)
    object LegalAgentScreen : RoutesJuridical(NavigationSteps.LegalAgentStep)
    object CommerceDataScreen : RoutesJuridical(NavigationSteps.CommerceDataStep)
    object BankDataScreen : RoutesJuridical(NavigationSteps.BankingDataStep)
    object UploadDocsScreen : RoutesJuridical(NavigationSteps.UploadDocsStep)
    object ReviewScreen : RoutesJuridical(NavigationSteps.ReviewScreen)
    object SignDocsScreen : RoutesJuridical(NavigationSteps.SignDocsStep)
    object DocsViewerScreen : RoutesJuridical(NavigationSteps.DocsViewerStep)
    object FinishScreen : RoutesJuridical(NavigationSteps.FinishStep)
    object UAFScreen : RoutesJuridical(NavigationSteps.UAFScreen)

}