package com.example.awantrixprojects

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.awantrixprojects.ui.screens.Home
import com.example.awantrixprojects.ui.screens.Orders
import com.example.awantrixprojects.ui.screens.Task
import com.example.awantrixprojects.ui.screens.Unlocked


@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.Home.navRoute
    ) {
        composable(BottomNavItem.Home.navRoute) {
            Home()
        }
        composable(BottomNavItem.Order.navRoute) {
            Orders()
        }
        composable(BottomNavItem.Task.navRoute) {
            Task()
        }
        composable(BottomNavItem.Unlocked.navRoute) {
            Unlocked()
        }
    }
}