package com.febrian.vehiclesales.ui.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.febrian.vehiclesales.ui.screen.HomeScreen
import com.febrian.vehiclesales.ui.screen.ReceiptScreen
import com.febrian.vehiclesales.ui.screen.VehicleScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavigationSetup(navController: NavHostController) {
    NavHost(navController, startDestination = Screen.Home.route) {
        composable(BottomNavMenuItem.Home.route) {
            HomeScreen()
        }
        composable(BottomNavMenuItem.Transaction.route) {
            ReceiptScreen()
        }
        composable(BottomNavMenuItem.Vehicle.route) {
            VehicleScreen()
        }

    }
}