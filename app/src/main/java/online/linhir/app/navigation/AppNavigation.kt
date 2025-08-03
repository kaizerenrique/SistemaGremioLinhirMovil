package online.linhir.app.navigation

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
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
        materialAnimation(route = AppScreens.ValidationScreen.route){
            ValidationScreen(navController)
        }
        materialAnimation(route = AppScreens.LoginScreen.route){
            LoginScreen(navController)
        }
        materialAnimation(route = AppScreens.HomeScreen.route){
            HomeScreen(navController)
        }
        materialAnimation(route = AppScreens.MembersScreen.route){
            MembersScreen(navController)
        }
        materialAnimation(route = AppScreens.PaymentsScreen.route){
            PaymentsScreen(navController)
        }
        materialAnimation(route = AppScreens.AboutScreen.route){
            AboutScreen(navController)
        }
        materialAnimation(route = AppScreens.NotificationsScreen.route){
            NotificationsScreen(navController)
        }
        materialAnimation(route = AppScreens.SettingsScreen.route){
            SettingsScreen(navController)
        }
    }
}

fun NavGraphBuilder.materialAnimation(route: String, content: @Composable () -> Unit) {
    composable(
        route = route,
        enterTransition = {
            slideInHorizontally(
                initialOffsetX = { it },
                animationSpec = tween(300, easing = FastOutSlowInEasing)
            ) + fadeIn(tween(300))
        },
        exitTransition = {
            slideOutHorizontally(
                targetOffsetX = { -it },
                animationSpec = tween(300, easing = FastOutSlowInEasing)
            ) + fadeOut(tween(300))
        },
        popEnterTransition = {
            slideInHorizontally(
                initialOffsetX = { -it },
                animationSpec = tween(300, easing = FastOutSlowInEasing)
            ) + fadeIn(tween(300))
        },
        popExitTransition = {
            slideOutHorizontally(
                targetOffsetX = { it },
                animationSpec = tween(300, easing = FastOutSlowInEasing)
            ) + fadeOut(tween(300))
        }
    ) { content() }
}