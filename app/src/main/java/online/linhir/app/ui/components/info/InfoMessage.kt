package online.linhir.app.ui.components.info

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import online.linhir.app.ui.theme.LinhirAppTheme
import online.linhir.app.ui.theme.getCustomColors

@Composable
fun InfoMessage(
    message: String,
    modifier: Modifier = Modifier,
    isVisible: Boolean = true,
    icon: ImageVector = Icons.Default.Info,
    iconSize: Dp = 16.dp,
    textStyle: TextStyle = MaterialTheme.typography.bodySmall
) {
    if (isVisible && message.isNotBlank()) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(
                imageVector = icon,
                contentDescription = "Info",
                modifier = Modifier.size(iconSize),
                tint = getCustomColors().info
            )

            Spacer(modifier = Modifier.width(6.dp))

            Text(
                text = message,
                style = textStyle,
                color = getCustomColors().info
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun InfoMessagePreview() {
    LinhirAppTheme {
        InfoMessage(
            message = "Los datos se actualizan cada 5 minutos"
        )
    }
}