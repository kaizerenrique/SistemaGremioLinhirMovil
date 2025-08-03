package online.linhir.app.features.payments

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
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
fun PaymentsScreen(navController: NavController) {
    Scaffold(
        topBar = {
            CustomToolbar(
                title = stringResource(R.string.payments),
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
        title = stringResource(R.string.payments),
        message = "La sección de pagos está en desarrollo. Aquí podrás gestionar las contribuciones del gremio, ver el estado de pagos de los miembros y administrar las finanzas del gremio Linhir.",
        color = MaterialTheme.colorScheme.primary
    )
}

@Preview (showBackground = true)
@Composable
fun PaymentsScreenPreview() {
    LinhirAppTheme {
        PaymentsScreen(navController = NavController(LocalContext.current))
    }
}