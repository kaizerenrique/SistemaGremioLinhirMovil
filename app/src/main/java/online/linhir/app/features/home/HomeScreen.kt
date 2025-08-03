package online.linhir.app.features.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import kotlinx.coroutines.launch
import online.linhir.app.R
import online.linhir.app.navigation.AppScreens
import online.linhir.app.ui.components.info.InfoScreen
import online.linhir.app.ui.components.navigation.CustomToolbar
import online.linhir.app.ui.components.navigation.DrawerContent
import online.linhir.app.ui.components.navigation.ToolbarAction
import online.linhir.app.ui.components.navigation.ToolbarType
import online.linhir.app.ui.theme.LinhirAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    var currentRoute by remember { mutableStateOf("home_screen") }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerContent(
                currentRoute = currentRoute,
                onItemClick = { route ->
                    currentRoute = route
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
                    }
                }
            )
        }
    ) {
        Scaffold(
            topBar = {
                CustomToolbar(
                    title = stringResource(R.string.home),
                    type = ToolbarType.HOME,
                    onNavigationClick = {
                        scope.launch {
                            drawerState.open()
                        }
                    },
                    actions = listOf(
                        ToolbarAction(
                            icon = Icons.Default.Notifications,
                            contentDescription = stringResource(R.string.notifications),
                            onClick = {}
                        ),
                        ToolbarAction(
                            icon = Icons.Default.Settings,
                            contentDescription = stringResource(R.string.settings),
                            onClick = {}
                        )
                    )
                )
            }
        ) { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                BodyContent()
            }
        }
    }
}

@Composable
fun BodyContent() {
    InfoScreen(
        title = "¡Bienvenido al Gremio Linhir!",
        message = "La aplicación del gremio está en desarrollo. Proximamente podrás acceder a todas las funciones como visualización de miembros, pagos y mucho más. Explora las opciones del menú para conocer las próximas características."
    )
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    LinhirAppTheme {
        HomeScreen(navController = NavController(LocalContext.current))
    }
}