package online.linhir.app.ui.components.navigation

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import online.linhir.app.R
import online.linhir.app.ui.theme.LinhirAppTheme

data class DrawerMenuItem(
    val title: String,
    val icon: ImageVector? = null,
    @DrawableRes val iconDrawable: Int? = null,
    val route: String,
    val isSelected: Boolean = false
)

@Composable
fun DrawerContent(
    currentRoute: String,
    onItemClick: (String) -> Unit,
    modifier: Modifier = Modifier,
    userName: String = "Usuario",
    userEmail: String = "usuario@linhir.online"
) {
    val menuItems = listOf(
        DrawerMenuItem(
            title = "Inicio",
            icon = Icons.Default.Home,
            route = "home_screen",
            isSelected = currentRoute == "home_screen"
        ),
        DrawerMenuItem(
            title = "Integrantes",
            icon = Icons.Default.Person,
            route = "members_screen",
            isSelected = currentRoute == "members_screen"
        ),
        DrawerMenuItem(
            title = "Pagos",
            iconDrawable = R.drawable.ic_money,
            route = "members_screen",
            isSelected = currentRoute == "members_screen"
        ),
    )

    Column(
        modifier = modifier
            .fillMaxHeight()
            .width(280.dp)
            .background(MaterialTheme.colorScheme.surface)
            .padding(16.dp)
    ) {
        DrawerHeader(
            userName = userName,
            userEmail = userEmail
        )

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            menuItems.forEach { item ->
                DrawerMenuItem(
                    item = item,
                    onClick = { onItemClick(item.route) }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DrawerContentPreview() {
    LinhirAppTheme {
        DrawerContent(
            currentRoute = "home_screen",
            onItemClick = { },
            userName = "Kaizer Enrique",
            userEmail = "kaizer@linhir.online"
        )
    }
}