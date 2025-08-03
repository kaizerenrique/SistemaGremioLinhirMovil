package online.linhir.app.features.members

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
fun MembersScreen(navController: NavController) {
    DrawerScaffold(
        navController = navController,
        currentRoute = "members_screen",
        title = stringResource(R.string.members)
    ) {
        BodyContent()
    }
}

@Composable
fun BodyContent() {
    InfoScreen(
        title = stringResource(R.string.members),
        message = "La sección de integrantes está en desarrollo. Aquí podrás ver todos los miembros del gremio Linhir, sus estadísticas y más.",
        color = MaterialTheme.colorScheme.primary
    )
}

@Preview (showBackground = true)
@Composable
fun MembersScreenPreview() {
    LinhirAppTheme {
        MembersScreen(navController = NavController(LocalContext.current))
    }
}