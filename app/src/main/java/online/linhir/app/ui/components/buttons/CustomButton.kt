package online.linhir.app.ui.components.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import online.linhir.app.ui.theme.LinhirAppTheme
import online.linhir.app.ui.theme.getCustomColors

enum class ButtonVariant {
    FILLED,
    OUTLINED,
    TEXT
}

enum class ButtonColor {
    PRIMARY,
    SECONDARY,
    ERROR,
    SUCCESS,
    WARNING,
    INFO
}

enum class IconPosition {
    START,
    END
}

@Composable
fun CustomButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    variant: ButtonVariant = ButtonVariant.FILLED,
    color: ButtonColor = ButtonColor.PRIMARY,
    enabled: Boolean = true,
    icon: ImageVector? = null,
    iconPosition: IconPosition = IconPosition.START,
    fillMaxWidth: Boolean = false
) {
    val customColors = getCustomColors()

    val (containerColor, contentColor, disabledContainerColor, disabledContentColor, borderColor) = when (color) {
        ButtonColor.PRIMARY -> listOf(
            MaterialTheme.colorScheme.primary,
            MaterialTheme.colorScheme.onPrimary,
            customColors.gray200,
            customColors.gray500,
            MaterialTheme.colorScheme.primary
        )
        ButtonColor.SECONDARY -> listOf(
            MaterialTheme.colorScheme.secondary,
            MaterialTheme.colorScheme.onSecondary,
            customColors.gray200,
            customColors.gray500,
            MaterialTheme.colorScheme.secondary
        )
        ButtonColor.ERROR -> listOf(
            MaterialTheme.colorScheme.error,
            MaterialTheme.colorScheme.onError,
            customColors.gray200,
            customColors.gray500,
            MaterialTheme.colorScheme.error
        )
        ButtonColor.SUCCESS -> listOf(
            customColors.success,
            Color.White,
            customColors.gray200,
            customColors.gray500,
            customColors.success
        )
        ButtonColor.WARNING -> listOf(
            customColors.warning,
            Color.White,
            customColors.gray200,
            customColors.gray500,
            customColors.warning
        )
        ButtonColor.INFO -> listOf(
            customColors.info,
            Color.White,
            customColors.gray200,
            customColors.gray500,
            customColors.info
        )
    }

    val buttonModifier = modifier
        .then(
            if (fillMaxWidth) Modifier.fillMaxWidth() else Modifier
        )
        .height(48.dp)

    when (variant) {
        ButtonVariant.FILLED -> {
            Button(
                onClick = onClick,
                modifier = buttonModifier,
                enabled = enabled,
                shape = RoundedCornerShape(8.dp),
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = containerColor,
                    contentColor = contentColor,
                    disabledContainerColor = disabledContainerColor,
                    disabledContentColor = disabledContentColor
                )
            ) {
                ButtonContent(
                    text = text,
                    icon = icon,
                    iconPosition = iconPosition
                )
            }
        }
        ButtonVariant.OUTLINED -> {
            OutlinedButton(
                onClick = onClick,
                modifier = buttonModifier,
                enabled = enabled,
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color.Transparent,
                    contentColor = borderColor,
                    disabledContainerColor = Color.Transparent,
                    disabledContentColor = disabledContentColor
                ),
                border = BorderStroke(
                    width = 1.dp,
                    color = if (enabled) borderColor else customColors.gray300
                )
            ) {
                ButtonContent(
                    text = text,
                    icon = icon,
                    iconPosition = iconPosition
                )
            }
        }
        ButtonVariant.TEXT -> {
            TextButton(
                onClick = onClick,
                modifier = buttonModifier,
                enabled = enabled,
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.textButtonColors(
                    containerColor = Color.Transparent,
                    contentColor = borderColor,
                    disabledContainerColor = Color.Transparent,
                    disabledContentColor = disabledContentColor
                )
            ) {
                ButtonContent(
                    text = text,
                    icon = icon,
                    iconPosition = iconPosition
                )
            }
        }
    }
}

@Composable
private fun ButtonContent(
    text: String,
    icon: ImageVector?,
    iconPosition: IconPosition
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        if (icon != null && iconPosition == IconPosition.START) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
        }

        Text(
            text = text,
            style = MaterialTheme.typography.labelLarge.copy(
                fontWeight = FontWeight.SemiBold
            )
        )

        if (icon != null && iconPosition == IconPosition.END) {
            Spacer(modifier = Modifier.width(8.dp))
            Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier.size(20.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CustomButtonPreview() {
    LinhirAppTheme {
        androidx.compose.foundation.layout.Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            CustomButton(
                text = "Primario",
                onClick = { },
                color = ButtonColor.PRIMARY,
                variant = ButtonVariant.FILLED,
                fillMaxWidth = true
            )

            CustomButton(
                text = "Error",
                onClick = { },
                color = ButtonColor.ERROR,
                variant = ButtonVariant.FILLED,
                fillMaxWidth = true
            )

            CustomButton(
                text = "Éxito",
                onClick = { },
                color = ButtonColor.SUCCESS,
                variant = ButtonVariant.FILLED,
                fillMaxWidth = true
            )

            CustomButton(
                text = "Información",
                onClick = { },
                color = ButtonColor.INFO,
                variant = ButtonVariant.FILLED,
                fillMaxWidth = true
            )
        }
    }
}