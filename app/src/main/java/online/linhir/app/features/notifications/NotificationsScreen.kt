package online.linhir.app.features.notifications

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import online.linhir.app.ui.theme.LinhirAppTheme

@Composable
fun NotificationsScreen(navController: NavController) {
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

}

@Preview (showBackground = true)
@Composable
fun NotificationsScreenPreview() {
    LinhirAppTheme {
        NotificationsScreen(navController = NavController(LocalContext.current))
    }
}