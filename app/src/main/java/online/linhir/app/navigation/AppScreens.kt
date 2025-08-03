package online.linhir.app.navigation

sealed class AppScreens (val route: String) {
    object ValidationScreen: AppScreens("validation_screen")
    object LoginScreen: AppScreens("login_screen")
    object HomeScreen: AppScreens("home_screen")
    object MembersScreen: AppScreens("members_screen")
    object PaymentsScreen: AppScreens("payments_screen")
    object AboutScreen: AppScreens("about_screen")
    object NotificationsScreen: AppScreens("notifications_screen")
    object SettingsScreen: AppScreens("settings_screen")
}