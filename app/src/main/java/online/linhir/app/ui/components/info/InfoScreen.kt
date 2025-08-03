package online.linhir.app.ui.components.info

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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import online.linhir.app.ui.components.buttons.ButtonColor
import online.linhir.app.ui.components.buttons.ButtonVariant
import online.linhir.app.ui.components.buttons.CustomButton
import online.linhir.app.ui.theme.LinhirAppTheme

@Composable
fun InfoScreen(
    title: String = "Información",
    message: String,
    onAction: (() -> Unit)? = null,
    onGoBack: (() -> Unit)? = null,
    actionButtonText: String = "Continuar",
    goBackButtonText: String = "Ir atrás"
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        InfoIndicator(
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

        if (onAction != null || onGoBack != null) {
            Spacer(modifier = Modifier.height(32.dp))

            when {
                onAction != null && onGoBack != null -> {
                    CustomButton(
                        text = actionButtonText,
                        onClick = onAction,
                        variant = ButtonVariant.FILLED,
                        color = ButtonColor.INFO,
                        modifier = Modifier.width(200.dp)
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    CustomButton(
                        text = goBackButtonText,
                        onClick = onGoBack,
                        variant = ButtonVariant.OUTLINED,
                        color = ButtonColor.INFO,
                        modifier = Modifier.width(200.dp)
                    )
                }
                onAction != null -> {
                    CustomButton(
                        text = actionButtonText,
                        onClick = onAction,
                        variant = ButtonVariant.FILLED,
                        color = ButtonColor.INFO,
                        modifier = Modifier.width(200.dp)
                    )
                }
                onGoBack != null -> {
                    CustomButton(
                        text = goBackButtonText,
                        onClick = onGoBack,
                        variant = ButtonVariant.FILLED,
                        color = ButtonColor.INFO,
                        modifier = Modifier.width(200.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun InfoScreenOneButtonPreview() {
    LinhirAppTheme {
        InfoScreen(
            title = "Función en desarrollo",
            message = "Esta característica estará disponible próximamente. Te notificaremos cuando esté lista.",
            onAction = { },
            actionButtonText = "Notificarme"
        )
    }
}