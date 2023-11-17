package com.febrian.vehiclesales

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Sort
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.febrian.vehiclesales.ui.components.OrderSection
import com.febrian.vehiclesales.ui.screen.ItemCar
import com.febrian.vehiclesales.ui.screen.ItemMotorCycle
import com.febrian.vehiclesales.ui.screen.VehicleViewModel
import com.febrian.vehiclesales.ui.theme.VehicleSalesTheme
import com.febrian.vehiclesales.utils.PreferenceManager
import com.febrian.vehiclesales.utils.TypeVehicle
import com.febrian.vehiclesales.utils.keyInsertData
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var preferenceManager: PreferenceManager

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VehicleSalesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {

                    val vehicleViewModel: VehicleViewModel by viewModels()

                    if (preferenceManager.getString(keyInsertData).isEmpty()) {
                        preferenceManager.putString(keyInsertData, "keyInsertData")
                        vehicleViewModel.insertAllVehicles()
                    }

                    vehicleViewModel.getAllCars()
                    vehicleViewModel.getAllMotorCycles()

                    var showTypeVehicle by remember {
                        mutableStateOf(false)
                    }

                    var typeVehicle by remember {
                        mutableStateOf(TypeVehicle.All)
                    }

                    val listCar = vehicleViewModel.getCars.collectAsState()
                    val listMotorCycle = vehicleViewModel.getMotorCycles.collectAsState()

                    Scaffold(floatingActionButton = {
                        FloatingActionButton(
                            onClick = {
                                vehicleViewModel.deleteAllVehicles()
                                preferenceManager.putString(keyInsertData, "")
                            },
                        ) {
                            Icon(
                                Icons.Filled.Delete,
                                "Clear Data Dummy",
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }
                    }) { padding ->
                        LazyColumn(
                            modifier = Modifier
                                .padding(padding)
                                .fillMaxWidth()
                        ) {

                            item {
                                Row(
                                    modifier = Modifier
                                        .padding(16.dp)
                                        .fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text(
                                        "Vehicle Sales",
                                        fontSize = 24.sp,
                                        fontWeight = FontWeight.Bold
                                    )

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
                                    Text(
                                        "Car",
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.padding(start = 16.dp)
                                    )
                                }

                                items(listCar.value) {
                                    ItemCar(it)
                                }
                            }

                            if (typeVehicle == TypeVehicle.MotorCycle || typeVehicle == TypeVehicle.All) {
                                item {
                                    Text(
                                        "Motorcycle",
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.padding(start = 16.dp)
                                    )
                                }

                                items(listMotorCycle.value) {
                                    ItemMotorCycle(it)
                                }

                            }
                        }
                    }

                }
            }
        }
    }
}
