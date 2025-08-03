package online.linhir.app.ui.components.loading

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import online.linhir.app.ui.theme.LinhirAppTheme
import online.linhir.app.ui.theme.getCustomColors

@Composable
fun LoadingIndicator(
    modifier: Modifier = Modifier,
    size: Dp = 32.dp,
    color: Color = getCustomColors().success,
    strokeWidth: Dp = 3.dp
) {
    val infiniteTransition = rememberInfiniteTransition(label = "loading_rotation")

    val rotation by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "loading_rotation"
    )

    CircularProgressIndicator(
        modifier = modifier
            .size(size)
            .rotate(rotation),
        color = color,
        strokeWidth = strokeWidth,
        strokeCap = StrokeCap.Round
    )
}

@Preview(showBackground = true)
@Composable
fun LoadingIndicatorPreview() {
    LinhirAppTheme {
        LoadingIndicator()
    }
}