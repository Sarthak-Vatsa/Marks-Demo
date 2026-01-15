package com.example.marksapplw.Navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Create
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(
    val route: String,
    val label: String,
    val icon: ImageVector
) {
    object Home : BottomNavItem("home", "Home", Icons.Filled.Home)
    object Practice : BottomNavItem("practice", "Practice", Icons.Filled.Create)
    object Tests : BottomNavItem("tests", "Tests", Icons.Filled.List)
    object Profile : BottomNavItem("profile", "Profile", Icons.Filled.Person)
}