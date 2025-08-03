package online.linhir.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import online.linhir.app.features.about.AboutScreen
import online.linhir.app.features.home.HomeScreen
import online.linhir.app.features.login.LoginScreen
import online.linhir.app.features.members.MembersScreen
import online.linhir.app.features.notifications.NotificationsScreen
import online.linhir.app.features.payments.PaymentsScreen
import online.linhir.app.features.settings.SettingsScreen
import online.linhir.app.features.validation.ValidationScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.ValidationScreen.route){
        composable(route = AppScreens.ValidationScreen.route){
            ValidationScreen(navController)
        }
        composable(route = AppScreens.LoginScreen.route){
            LoginScreen(navController)
        }
        composable(route = AppScreens.HomeScreen.route){
            HomeScreen(navController)
        }
        composable(route = AppScreens.MembersScreen.route){
            MembersScreen(navController)
        }
        composable(route = AppScreens.PaymentsScreen.route){
            PaymentsScreen(navController)
        }
        composable(route = AppScreens.AboutScreen.route){
            AboutScreen(navController)
        }
        composable(route = AppScreens.NotificationsScreen.route){
            NotificationsScreen(navController)
        }
        composable(route = AppScreens.SettingsScreen.route){
            SettingsScreen(navController)
        }
    }
}