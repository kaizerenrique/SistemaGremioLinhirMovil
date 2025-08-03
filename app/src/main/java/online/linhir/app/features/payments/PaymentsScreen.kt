package online.linhir.app.features.payments

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import online.linhir.app.R
import online.linhir.app.ui.components.info.InfoScreen
import online.linhir.app.ui.theme.LinhirAppTheme

@Composable
fun PaymentsScreen(navController: NavController) {
    Scaffold { paddingValues ->
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
        message = "La sección de pagos está en desarrollo. Aquí podrás gestionar las contribuciones del gremio, ver el estado de pagos de los miembros y administrar las finanzas del gremio Linhir."
    )
}

@Preview (showBackground = true)
@Composable
fun PaymentsScreenPreview() {
    LinhirAppTheme {
        PaymentsScreen(navController = NavController(LocalContext.current))
    }
}