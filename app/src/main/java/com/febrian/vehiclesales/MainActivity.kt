package com.febrian.vehiclesales

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.febrian.vehiclesales.ui.screen.VehicleViewModel
import com.febrian.vehiclesales.ui.theme.VehicleSalesTheme
import com.febrian.vehiclesales.utils.PreferenceManager
import com.febrian.vehiclesales.utils.createDummyCarList
import com.febrian.vehiclesales.utils.createDummyMotorCycleList
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
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val vehicleViewModel: VehicleViewModel by viewModels()

                    if (preferenceManager.getString(keyInsertData).isEmpty()) {
                        preferenceManager.putString(keyInsertData, "keyInsertData")
                        vehicleViewModel.insertAllVehicles()
                    }

                    Scaffold(
                        floatingActionButton = {
                            FloatingActionButton(
                                onClick = {
                                    vehicleViewModel.deleteAllVehicles()
                                    preferenceManager.putString(keyInsertData, "")
                                },
                            ) {
                                Icon(Icons.Filled.Delete, "Clear Data Dummy", tint = MaterialTheme.colorScheme.primary)
                            }
                        }
                    ) { padding ->
                        Column(
                            modifier = Modifier.padding(padding)
                        ) {

                        }
                    }

                }
            }
        }
    }
}
