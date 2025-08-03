package online.linhir.app.features.about

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import online.linhir.app.R
import online.linhir.app.ui.components.info.InfoScreen
import online.linhir.app.ui.components.navigation.DrawerScaffold
import online.linhir.app.ui.theme.LinhirAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutScreen(navController: NavController) {
    DrawerScaffold(
        navController = navController,
        currentRoute = "about_screen",
        title = stringResource(R.string.about)
    ) {
        BodyContent()
    }
}

@Composable
fun BodyContent() {
    InfoScreen(
        title = stringResource(R.string.about),
        message = "Linhir es un gremio de Albion Online ubicado en Fort Sterling, servidor West. Esta aplicación fue desarrollada para facilitar la comunicación y gestión entre los miembros del gremio.\n\nDesarrollado por kaizerenrique y Mayker451, para la comunidad de Linhir.",
        color = MaterialTheme.colorScheme.primary
    )
}

@Preview (showBackground = true)
@Composable
fun AboutScreenPreview() {
    LinhirAppTheme {
        AboutScreen(navController = NavController(LocalContext.current))
    }
}