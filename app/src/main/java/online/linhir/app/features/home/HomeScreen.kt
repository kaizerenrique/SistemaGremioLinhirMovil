package online.linhir.app.features.home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import online.linhir.app.R
import online.linhir.app.navigation.AppScreens
import online.linhir.app.ui.components.info.InfoScreen
import online.linhir.app.ui.components.navigation.DrawerScaffold
import online.linhir.app.ui.components.navigation.ToolbarAction
import online.linhir.app.ui.theme.LinhirAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    DrawerScaffold(
        navController = navController,
        currentRoute = "home_screen",
        title = stringResource(R.string.home),
        actions = listOf(
            ToolbarAction(
                icon = Icons.Default.Notifications,
                contentDescription = stringResource(R.string.notifications),
                onClick = {
                    navController.navigate(AppScreens.NotificationsScreen.route)
                }
            ),
            ToolbarAction(
                icon = Icons.Default.Settings,
                contentDescription = stringResource(R.string.settings),
                onClick = {
                    navController.navigate(AppScreens.SettingsScreen.route)
                }
            )
        )
    ) {
        BodyContent()
    }
}

@Composable
fun BodyContent() {
    InfoScreen(
        title = "¡Bienvenido al Gremio Linhir!",
        message = "La aplicación del gremio está en desarrollo. Proximamente podrás acceder a todas las funciones como visualización de miembros, pagos y mucho más. Explora las opciones del menú para conocer las próximas características.",
        color = MaterialTheme.colorScheme.primary
    )
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    LinhirAppTheme {
        HomeScreen(navController = NavController(LocalContext.current))
    }
}