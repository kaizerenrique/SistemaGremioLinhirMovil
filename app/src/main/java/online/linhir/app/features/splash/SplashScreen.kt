package online.linhir.app.features.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import online.linhir.app.R
import online.linhir.app.navigation.AppScreens
import online.linhir.app.ui.theme.LinhirAppTheme

@Composable
fun SplashScreen(navController: NavController) {
    var showInitializing by remember { mutableStateOf(false) }

    LaunchedEffect(true) {
        delay(3000)
        showInitializing = true
        delay(2000)

        navController.navigate(AppScreens.LoginScreen.route) {
            popUpTo(AppScreens.SplashScreen.route) {
                inclusive = true
            }
        }
    }

    Box(modifier = Modifier
        .fillMaxSize()
        .systemBarsPadding()
    ) {
        BodyContent(showInitializing = showInitializing)
    }
}

@Composable
fun BodyContent(
    showInitializing: Boolean
) {
    Image(
        painter = painterResource(id = R.drawable.albion_background),
        contentDescription = null,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.6f))
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier.size(200.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            if (showInitializing)
                stringResource(R.string.starting_adventure)
            else
                stringResource(id = R.string.app_name),
            style = MaterialTheme.typography.headlineLarge.copy(
                color = Color.White,
                shadow = Shadow(
                    color = Color.Black,
                    offset = Offset(2f, 2f),
                    blurRadius = 4f
                )
            ),
            textAlign = TextAlign.Center
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