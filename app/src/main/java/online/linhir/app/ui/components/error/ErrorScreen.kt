package online.linhir.app.ui.components.error

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import online.linhir.app.ui.components.buttons.ButtonVariant
import online.linhir.app.ui.components.buttons.CustomButton
import online.linhir.app.ui.theme.LinhirAppTheme

@Composable
fun ErrorScreen(
    title: String = "Error",
    message: String,
    onRetry: (() -> Unit)? = null,
    onGoBack: (() -> Unit)? = null,
    retryButtonText: String = "Reintentar",
    goBackButtonText: String = "Ir atrás",
    backgroundColor: Color = MaterialTheme.colorScheme.background
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ErrorIndicator(
            message = title,
            iconSize = 64.dp,
            textStyle = MaterialTheme.typography.headlineMedium.copy(
                fontWeight = FontWeight.Bold
            )
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = message,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(32.dp))

        when {
            onRetry != null && onGoBack != null -> {
                CustomButton(
                    text = retryButtonText,
                    onClick = onRetry,
                    variant = ButtonVariant.FILLED,
                    modifier = Modifier.width(200.dp)
                )

                Spacer(modifier = Modifier.height(12.dp))

                CustomButton(
                    text = goBackButtonText,
                    onClick = onGoBack,
                    variant = ButtonVariant.OUTLINED,
                    modifier = Modifier.width(200.dp)
                )
            }
            onRetry != null -> {
                CustomButton(
                    text = retryButtonText,
                    onClick = onRetry,
                    variant = ButtonVariant.FILLED,
                    modifier = Modifier.width(200.dp)
                )
            }
            onGoBack != null -> {
                CustomButton(
                    text = goBackButtonText,
                    onClick = onGoBack,
                    variant = ButtonVariant.FILLED,
                    modifier = Modifier.width(200.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ErrorScreenPreview() {
    LinhirAppTheme {
        ErrorScreen(
            title = "Sin conexión",
            message = "No se pudo conectar al servidor. Verifica tu conexión a internet y vuelve a intentar.",
            onRetry = { },
            onGoBack = { }
        )
    }
}