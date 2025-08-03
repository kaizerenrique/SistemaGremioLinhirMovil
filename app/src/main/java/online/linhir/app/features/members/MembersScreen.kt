package online.linhir.app.features.members

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
fun MembersScreen(navController: NavController) {
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
        title = stringResource(R.string.members),
        message = "La sección de integrantes está en desarrollo. Aquí podrás ver todos los miembros del gremio Linhir, sus estadísticas y más."
    )
}

@Preview (showBackground = true)
@Composable
fun MembersScreenPreview() {
    LinhirAppTheme {
        MembersScreen(navController = NavController(LocalContext.current))
    }
}