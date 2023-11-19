package com.febrian.vehiclesales.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Receipt
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavMenuItem(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home : BottomNavMenuItem(
        route = Screen.Home.route,
        title = "Home",
        icon = Icons.Default.Home
    )

    object Transaction : BottomNavMenuItem(
        route = Screen.Transaction.route,
        title = "Transaction",
        icon = Icons.Default.Receipt
    )

    object Vehicle : BottomNavMenuItem(
        route = Screen.Vehicle.route,
        title = "Vehicle",
        icon = Icons.Default.DirectionsCar
    )
}