package com.febrian.vehiclesales.ui.screen

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.febrian.vehiclesales.ui.components.TextTitleLarge
import com.febrian.vehiclesales.ui.item.ItemCar
import com.febrian.vehiclesales.ui.item.ItemMotorCycle
import com.febrian.vehiclesales.ui.navigation.Screen

@Composable
fun VehicleScreen(
    vehicleViewModel: VehicleViewModel = hiltViewModel(),
    navController: NavController = rememberNavController()
) {

    vehicleViewModel.getAllCars(true)
    vehicleViewModel.getAllMotorCycles(true)

    val listCar = vehicleViewModel.getCars.collectAsState()
    val listMotorCycle = vehicleViewModel.getMotorCycles.collectAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 56.dp)
    ) {
        item {
            TextTitleLarge(text = "Vehicle Mine", Modifier.padding(start = 16.dp, top = 16.dp))
            Spacer(modifier = Modifier.height(16.dp))
        }

        items(listCar.value) {
            ItemCar("Purchased", it) {
                navController.navigate(Screen.DetailCarScreen.route + "?id=${it.id}")
            }
        }

        items(listMotorCycle.value) {
            ItemMotorCycle("Purchased", it) {
                navController.navigate(Screen.DetailMotorScreen.route + "?id=${it.id}")
            }
        }
    }
}