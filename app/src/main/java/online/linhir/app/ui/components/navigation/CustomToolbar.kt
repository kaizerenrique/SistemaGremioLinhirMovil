package online.linhir.app.ui.components.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import online.linhir.app.R
import online.linhir.app.ui.theme.LinhirAppTheme

enum class ToolbarType {
    HOME,
    BACK,
    SIMPLE
}

data class ToolbarAction(
    val icon: ImageVector,
    val contentDescription: String,
    val onClick: () -> Unit
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomToolbar(
    modifier: Modifier = Modifier,
    title: String,
    subtitle: String? = null,
    type: ToolbarType = ToolbarType.HOME,
    onNavigationClick: () -> Unit = {},
    actions: List<ToolbarAction> = emptyList(),
    scrollBehavior: TopAppBarScrollBehavior? = null,
    backgroundColor: Color = MaterialTheme.colorScheme.surface,
    contentColor: Color = MaterialTheme.colorScheme.onSurface
) {
    TopAppBar(
        title = {
            if (subtitle != null) {
                TitleWithSubtitle(
                    title = title,
                    subtitle = subtitle,
                    contentColor = contentColor
                )
            } else {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    color = contentColor,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        },
        modifier = modifier,
        navigationIcon = {
            when (type) {
                ToolbarType.HOME -> {
                    IconButton(onClick = onNavigationClick) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Abrir menú",
                            tint = contentColor
                        )
                    }
                }
                ToolbarType.BACK -> {
                    IconButton(onClick = onNavigationClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Regresar",
                            tint = contentColor
                        )
                    }
                }
                ToolbarType.SIMPLE -> {
                    // Sin icono de navegación
                }
            }
        },
        actions = {
            actions.forEach { action ->
                IconButton(onClick = action.onClick) {
                    Icon(
                        imageVector = action.icon,
                        contentDescription = action.contentDescription,
                        tint = contentColor
                    )
                }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = backgroundColor,
            titleContentColor = contentColor,
            navigationIconContentColor = contentColor,
            actionIconContentColor = contentColor
        ),
        scrollBehavior = scrollBehavior
    )
}

@Composable
private fun TitleWithSubtitle(
    title: String,
    subtitle: String,
    contentColor: Color
) {
    Column {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge.copy(
                fontWeight = FontWeight.Bold
            ),
            color = contentColor,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        Text(
            text = subtitle,
            style = MaterialTheme.typography.bodySmall,
            color = contentColor.copy(alpha = 0.8f),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun CustomToolbarPreview() {
    LinhirAppTheme {
        Column {
            CustomToolbar(
                title = stringResource(id = R.string.app_name),
                subtitle = stringResource(R.string.albion_guild),
                type = ToolbarType.HOME,
                onNavigationClick = { },
                actions = listOf(
                    ToolbarAction(
                        icon = Icons.Default.Notifications,
                        contentDescription = "Notificaciones",
                        onClick = { }
                    ),
                    ToolbarAction(
                        icon = Icons.Default.Settings,
                        contentDescription = "Ajustes",
                        onClick = { }
                    )
                )
            )

            Spacer(modifier = Modifier.width(16.dp))

            CustomToolbar(
                title = "Miembros del Gremio",
                subtitle = "24 miembros conectados",
                type = ToolbarType.BACK,
                onNavigationClick = { },
                actions = listOf(
                    ToolbarAction(
                        icon = Icons.Default.Search,
                        contentDescription = "Buscar miembros",
                        onClick = { }
                    ),
                )
            )

            Spacer(modifier = Modifier.width(16.dp))

            CustomToolbar(
                title = "Configuración",
                type = ToolbarType.SIMPLE,
                actions = listOf(
                    ToolbarAction(
                        icon = Icons.Default.MoreVert,
                        contentDescription = "Menú",
                        onClick = { }
                    )
                )
            )
        }
    }
}