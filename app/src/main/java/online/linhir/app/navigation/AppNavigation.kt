package online.linhir.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import online.linhir.app.features.home.HomeScreen
import online.linhir.app.features.login.LoginScreen
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
    }
}