package online.linhir.app.ui.components.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import kotlinx.coroutines.launch
import online.linhir.app.navigation.AppScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrawerScaffold(
    navController: NavController,
    currentRoute: String,
    title: String,
    actions: List<ToolbarAction> = emptyList(),
    content: @Composable () -> Unit
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerContent(
                currentRoute = currentRoute,
                onItemClick = { route ->
                    scope.launch {
                        drawerState.close()
                    }
                    if (route != currentRoute) {
                        navigateToRoute(navController, route)
                    }
                }
            )
        }
    ) {
        Scaffold(
            topBar = {
                CustomToolbar(
                    title = title,
                    type = ToolbarType.HOME,
                    onNavigationClick = {
                        scope.launch {
                            drawerState.open()
                        }
                    },
                    actions = actions
                )
            }
        ) { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                content()
            }
        }
    }
}

private fun navigateToRoute(navController: NavController, route: String) {
    when (route) {
        "home_screen" -> {
            navController.navigate(AppScreens.HomeScreen.route) {
                popUpTo(AppScreens.HomeScreen.route) {
                    inclusive = true
                }
                launchSingleTop = true
            }
        }
        "members_screen" -> {
            navController.navigate(AppScreens.MembersScreen.route) {
                popUpTo(AppScreens.MembersScreen.route) {
                    inclusive = true
                }
                launchSingleTop = true
            }
        }
        "payments_screen" -> {
            navController.navigate(AppScreens.PaymentsScreen.route) {
                popUpTo(AppScreens.PaymentsScreen.route) {
                    inclusive = true
                }
                launchSingleTop = true
            }
        }
        "about_screen" -> {
            navController.navigate(AppScreens.AboutScreen.route) {
                popUpTo(AppScreens.AboutScreen.route) {
                    inclusive = true
                }
                launchSingleTop = true
            }
        }
    }
}