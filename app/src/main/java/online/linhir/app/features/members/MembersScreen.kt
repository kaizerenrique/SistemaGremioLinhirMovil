package online.linhir.app.features.members

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import online.linhir.app.ui.theme.LinhirAppTheme

@Composable
fun MembersScreen(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        BodyContent()
    }
}

@Composable
fun BodyContent() {
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("En desarrollo...")
    }
}

@Preview (showBackground = true)
@Composable
fun MembersScreenPreview() {
    LinhirAppTheme {
        MembersScreen(navController = NavController(LocalContext.current))
    }
}