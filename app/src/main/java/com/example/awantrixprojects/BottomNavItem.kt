package com.example.awantrixprojects

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.awantrixprojects.navroutes.NAV_HOME
import com.example.awantrixprojects.navroutes.NAV_ORDER
import com.example.awantrixprojects.navroutes.NAV_TASK
import com.example.awantrixprojects.navroutes.NAV_UNLOCKED

sealed class BottomNavItem(
    @StringRes val title: Int,
    @DrawableRes val icon: Int,
    val navRoute: String
) {
    object Home : BottomNavItem(R.string.home, R.drawable.ic_baseline_home_24, NAV_HOME)
    object Order : BottomNavItem(R.string.order, R.drawable.ic_baseline_shopping_cart_24, NAV_ORDER)
    object Task : BottomNavItem(R.string.task, R.drawable.ic_baseline_task_24, NAV_TASK)
    object Unlocked :
        BottomNavItem(R.string.unlocked, R.drawable.ic_baseline_lock_open_24, NAV_UNLOCKED)
}
