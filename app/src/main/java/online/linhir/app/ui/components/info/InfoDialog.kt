package online.linhir.app.ui.components.info

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import online.linhir.app.ui.components.buttons.ButtonColor
import online.linhir.app.ui.components.buttons.ButtonVariant
import online.linhir.app.ui.components.buttons.CustomButton
import online.linhir.app.ui.theme.LinhirAppTheme

@Composable
fun InfoDialog(
    isVisible: Boolean,
    title: String = "Información",
    message: String,
    onDismiss: () -> Unit,
    dismissButtonText: String = "Entendido"
) {
    if (isVisible) {
        Dialog(
            onDismissRequest = onDismiss,
            properties = DialogProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = true
            )
        ) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                ),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    InfoIndicator(
                        message = title,
                        iconSize = 32.dp,
                        textStyle = MaterialTheme.typography.headlineSmall.copy(
                            fontWeight = FontWeight.Bold
                        )
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = message,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurface,
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    CustomButton(
                        text = dismissButtonText,
                        onClick = onDismiss,
                        variant = ButtonVariant.FILLED,
                        color = ButtonColor.INFO,
                        fillMaxWidth = true
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun InfoDialogPreview() {
    LinhirAppTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Gray)
        ) {
            InfoDialog(
                isVisible = true,
                title = "Bienvenido",
                message = "Te has unido al gremio Linhir. Explora las diferentes secciones para conocer a tus compañeros.",
                onDismiss = { }
            )
        }
    }
}