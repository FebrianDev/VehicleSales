package com.febrian.vehiclesales.ui.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Sort
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.febrian.vehiclesales.data.entity.SaleCar
import com.febrian.vehiclesales.data.entity.SaleMotorCycle
import com.febrian.vehiclesales.ui.components.OrderSection
import com.febrian.vehiclesales.ui.components.TextSubtitleMedium
import com.febrian.vehiclesales.ui.components.TextTitleLarge
import com.febrian.vehiclesales.ui.item.ItemCar
import com.febrian.vehiclesales.ui.item.ItemMotorCycle
import com.febrian.vehiclesales.utils.TypeVehicle
import com.febrian.vehiclesales.utils.dateToString
import java.util.Date

@Composable
fun HomeScreen(
    vehicleViewModel: VehicleViewModel = hiltViewModel(),
    navController : NavController = rememberNavController()
) {

    vehicleViewModel.getAllCars(false)
    vehicleViewModel.getAllMotorCycles(false)

    var showTypeVehicle by remember {
        mutableStateOf(false)
    }

    var typeVehicle by remember {
        mutableStateOf(TypeVehicle.All)
    }

    val listCar = vehicleViewModel.getCars.collectAsState()
    val listMotorCycle = vehicleViewModel.getMotorCycles.collectAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 56.dp)
    ) {

        item {
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                TextTitleLarge(text = "Vehicle Sales")

                Icon(
                    Icons.Filled.Sort,
                    "Sort Item",
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.clickable {
                        showTypeVehicle = !showTypeVehicle
                    }
                )
            }
        }

        item {
            AnimatedVisibility(
                visible = showTypeVehicle,
                enter = fadeIn() + slideInVertically(),
                exit = fadeOut() + slideOutVertically()
            ) {
                OrderSection(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    typeVehicle
                ) { type ->
                    typeVehicle = type
                }

            }
        }

        if (typeVehicle == TypeVehicle.Car || typeVehicle == TypeVehicle.All) {
            item {
                TextSubtitleMedium(text = "Car", modifier = Modifier.padding(start = 16.dp))
            }

            items(listCar.value) {
                ItemCar("Buy Car", it, navController) {
                    val car = it
                    car.isPurchased = true
                    vehicleViewModel.buyCar(
                        SaleCar(carId = it.id, date = dateToString(Date())),
                        car
                    )
                }
            }
        }

        if (typeVehicle == TypeVehicle.MotorCycle || typeVehicle == TypeVehicle.All) {
            item {
                TextSubtitleMedium(text = "MotorCycle", modifier = Modifier.padding(start = 16.dp))
            }

            items(listMotorCycle.value) {
                ItemMotorCycle("Buy Motor", it, navController) {
                    val motor = it
                    motor.isPurchased = true
                    vehicleViewModel.buyMotor(
                        SaleMotorCycle(motorCycleId = it.id, date = dateToString(Date())),
                        motor
                    )

                }
            }

        }
    }
}