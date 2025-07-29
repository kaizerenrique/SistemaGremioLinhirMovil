package online.linhir.app.features.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay
import online.linhir.app.R
import online.linhir.app.navigation.AppScreens
import online.linhir.app.ui.theme.LinhirAppTheme

@Composable
fun SplashScreen(navController: NavController) {
    LaunchedEffect(true) {
        delay(1000)
        navController.navigate(AppScreens.LoginScreen.route)
    }

    Splash()
}

@Composable
fun Splash() {
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier.size(150.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            "Linhir App",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview (showBackground = true)
@Composable
fun SplashScreenPreview() {
    LinhirAppTheme {
        SplashScreen(navController = NavController(LocalContext.current))
    }
}