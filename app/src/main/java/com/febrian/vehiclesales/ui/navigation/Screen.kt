package com.febrian.vehiclesales.ui.navigation

sealed class Screen(val route : String){
    object Home : Screen("home_screen")
    object Transaction : Screen("transaction_screen")
    object Vehicle : Screen("vehicle_screen")
}
