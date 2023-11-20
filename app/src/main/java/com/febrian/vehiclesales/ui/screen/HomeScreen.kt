package com.febrian.vehiclesales.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.febrian.vehiclesales.ui.components.TextSubtitleMedium
import com.febrian.vehiclesales.ui.components.TextTitleLarge
import com.febrian.vehiclesales.ui.item.ItemCar
import com.febrian.vehiclesales.ui.item.ItemMotorCycle
import com.febrian.vehiclesales.ui.navigation.Screen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    vehicleViewModel: VehicleViewModel = hiltViewModel(),
    navController: NavController = rememberNavController()
) {

    vehicleViewModel.getAllCars(false)
    vehicleViewModel.getAllMotorCycles(false)

    val listCar = vehicleViewModel.getCars.collectAsState()
    val listMotorCycle = vehicleViewModel.getMotorCycles.collectAsState()

    Scaffold(floatingActionButton = {
        FloatingActionButton(
            onClick = {
                vehicleViewModel.deleteAllVehicles()
                vehicleViewModel.insertAllVehicles()
            },
            modifier = Modifier.padding(bottom = 56.dp)
        ) {
            Icon(
                Icons.Filled.Delete,
                "Clear Data Dummy",
                tint = MaterialTheme.colorScheme.primary,
            )
        }
    }) { _ ->

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 56.dp)
        ) {

            item {
                TextTitleLarge(
                    text = "Vehicle Sales",
                    modifier = Modifier.padding(start = 16.dp, top = 16.dp)
                )
            }


            item {
                TextSubtitleMedium(
                    text = "Car",
                    modifier = Modifier.padding(start = 16.dp, top = 16.dp)
                )
            }

            items(listCar.value) {
                ItemCar("Detail Car", it) {
                    navController.navigate(Screen.DetailCarScreen.route + "?id=${it.id}")
                }
            }


            item {
                TextSubtitleMedium(
                    text = "MotorCycle",
                    modifier = Modifier.padding(start = 16.dp, top = 8.dp)
                )
            }

            items(listMotorCycle.value) {
                ItemMotorCycle("Detail Motor", it) {
                    navController.navigate(Screen.DetailMotorScreen.route + "?id=${it.id}")
                }
            }

        }
    }
}