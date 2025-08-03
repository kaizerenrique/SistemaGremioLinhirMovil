package online.linhir.app.ui.components.info

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import online.linhir.app.ui.theme.LinhirAppTheme
import online.linhir.app.ui.theme.getCustomColors

@Composable
fun InfoIndicator(
    message: String,
    modifier: Modifier = Modifier,
    icon: ImageVector = Icons.Default.Info,
    iconSize: Dp = 20.dp,
    textStyle: TextStyle = MaterialTheme.typography.bodyMedium
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = icon,
            contentDescription = "Info",
            modifier = Modifier.size(iconSize),
            tint = getCustomColors().info
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = message,
            style = textStyle,
            color = getCustomColors().info,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun InfoIndicatorPreview() {
    LinhirAppTheme {
        InfoIndicator(
            message = "Información importante"
        )
    }
}