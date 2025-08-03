package online.linhir.app.features.notifications

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import online.linhir.app.R
import online.linhir.app.ui.components.info.InfoScreen
import online.linhir.app.ui.components.navigation.CustomToolbar
import online.linhir.app.ui.components.navigation.ToolbarType
import online.linhir.app.ui.theme.LinhirAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificationsScreen(navController: NavController) {
    Scaffold(
        topBar = {
            CustomToolbar(
                title = stringResource(R.string.notifications),
                type = ToolbarType.BACK,
                onNavigationClick = {
                    navController.popBackStack()
                }
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

@Composable
fun BodyContent() {
    InfoScreen(
        title = stringResource(R.string.notifications),
        message = "La sección de notificaciones está en desarrollo. Aquí recibirás alertas importantes del gremio, eventos de Albion Online, recordatorios de pagos y actualizaciones de actividades de los miembros de Linhir."
    )
}

@Preview (showBackground = true)
@Composable
fun NotificationsScreenPreview() {
    LinhirAppTheme {
        NotificationsScreen(navController = NavController(LocalContext.current))
    }
}