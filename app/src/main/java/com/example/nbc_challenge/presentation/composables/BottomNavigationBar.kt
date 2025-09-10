package com.example.nbc_challenge.presentation.composables

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.example.nbc_challenge.R

@Composable
fun BottomNavigationBar(selected: Int, onSelect: (Int) -> Unit) {
    data class Tab(val label: String, val icon: ImageVector)
    val tabs = listOf(
        Tab("Home", Icons.Outlined.Home),
        Tab("Shows", ImageVector.vectorResource(R.drawable.subscriptions_24px)),
        Tab("Live", ImageVector.vectorResource(R.drawable.stream_24px)),
        Tab("Search", Icons.Outlined.Search),
        Tab("More", ImageVector.vectorResource(R.drawable.more_horiz_24px))
    )

    NavigationBar(
        containerColor = Color(0xFF4B0082),
    ) {
        tabs.forEachIndexed { index, tab ->
            NavigationBarItem(
                selected = selected == index,
                onClick = { onSelect(index) },
                icon = { Icon(tab.icon, contentDescription = tab.label) },
                label = { Text(tab.label) },
                alwaysShowLabel = true,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.White,
                    selectedTextColor = Color.White,
                    unselectedIconColor = Color.White,
                    unselectedTextColor = Color.White,
                    indicatorColor = Color.Transparent
                )
            )
        }
    }
}