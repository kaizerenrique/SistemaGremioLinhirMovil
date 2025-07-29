package online.linhir.app.features.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import online.linhir.app.ui.theme.LinhirAppTheme

@Composable
fun LoginScreen(navController: NavController) {
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
fun LoginScreenPreview() {
    LinhirAppTheme {
        LoginScreen(navController = NavController(LocalContext.current))
    }
}