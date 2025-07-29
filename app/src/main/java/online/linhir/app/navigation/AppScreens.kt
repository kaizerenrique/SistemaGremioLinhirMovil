package online.linhir.app.navigation

sealed class AppScreens (val route: String) {
    object SplashScreen: AppScreens("Splash_screen")
    object LoginScreen: AppScreens("login_screen")
    object HomeScreen: AppScreens("home_screen")
}