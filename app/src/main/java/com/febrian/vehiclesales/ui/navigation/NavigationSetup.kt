package com.febrian.vehiclesales.ui.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.febrian.vehiclesales.ui.screen.DetailCarScreen
import com.febrian.vehiclesales.ui.screen.DetailMotorScreen
import com.febrian.vehiclesales.ui.screen.HomeScreen
import com.febrian.vehiclesales.ui.screen.ReceiptScreen
import com.febrian.vehiclesales.ui.screen.VehicleScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavigationSetup(
    navController: NavHostController = rememberNavController()
) {
    NavHost(navController, startDestination = Screen.Home.route) {
        composable(BottomNavMenuItem.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(BottomNavMenuItem.Transaction.route) {
            ReceiptScreen()
        }
        composable(BottomNavMenuItem.Vehicle.route) {
            VehicleScreen(navController = navController)
        }
        composable(Screen.DetailCarScreen.route + "?id={id}", arguments = listOf(navArgument("id") {
            type = NavType.IntType
            defaultValue = 0
        })) {
            DetailCarScreen(id = it.arguments?.getInt("id") ?: 0, navController = navController)
        }
        composable(
            Screen.DetailMotorScreen.route + "?id={id}",
            arguments = listOf(navArgument("id") {
                type = NavType.IntType
                defaultValue = 0
            })
        ) {
            DetailMotorScreen(it.arguments?.getInt("id") ?: 0, navController = navController)
        }

    }
}