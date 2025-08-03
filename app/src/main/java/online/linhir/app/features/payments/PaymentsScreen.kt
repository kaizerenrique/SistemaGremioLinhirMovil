package online.linhir.app.features.payments

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import online.linhir.app.R
import online.linhir.app.features.home.BodyContent
import online.linhir.app.ui.components.info.InfoScreen
import online.linhir.app.ui.components.navigation.DrawerScaffold
import online.linhir.app.ui.theme.LinhirAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaymentsScreen(navController: NavController) {
    DrawerScaffold(
        navController = navController,
        currentRoute = "payments_screen",
        title = stringResource(R.string.payments)
    ) {
        BodyContent()
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