package com.example.awantrixprojects

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun AppBottomNavigation(
    navController: NavHostController
) {
    val navItems =
        listOf(BottomNavItem.Home, BottomNavItem.Order, BottomNavItem.Task, BottomNavItem.Unlocked)
    BottomNavigation(
        backgroundColor = colorResource(id = R.color.white)
    )
    {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        navItems.forEach { items ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        painter = painterResource(id = items.icon),
                        contentDescription = " "
                    )
                },
                label = { Text(text = stringResource(id = items.title)) },
                selectedContentColor = Color.Blue,
                unselectedContentColor = Color.Black,//Color.Blue.copy(0.4f),
                selected = currentRoute == items.navRoute,
                onClick = {
                    navController.navigate(items.navRoute) {
                        popUpTo(navController.graph.findStartDestination().id)
                        launchSingleTop = true
                    }
                })
        }
    }
}