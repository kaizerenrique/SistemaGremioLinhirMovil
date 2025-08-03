package online.linhir.app.ui.components.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
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
    var selectedRoute by remember { mutableStateOf(currentRoute) }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerContent(
                currentRoute = selectedRoute,
                onItemClick = { route ->
                    selectedRoute = route
                    scope.launch {
                        drawerState.close()
                    }
                    when (route) {
                        "home_screen" -> {
                            navController.navigate(AppScreens.HomeScreen.route)
                        }
                        "members_screen" -> {
                            navController.navigate(AppScreens.MembersScreen.route)
                        }
                        "payments_screen" -> {
                            navController.navigate(AppScreens.PaymentsScreen.route)
                        }
                        "about_screen" -> {
                            navController.navigate(AppScreens.AboutScreen.route)
                        }
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