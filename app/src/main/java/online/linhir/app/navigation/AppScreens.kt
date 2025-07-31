package online.linhir.app.navigation

sealed class AppScreens (val route: String) {
    object ValidationScreen: AppScreens("validation_screen")
    object LoginScreen: AppScreens("login_screen")
    object HomeScreen: AppScreens("home_screen")
}