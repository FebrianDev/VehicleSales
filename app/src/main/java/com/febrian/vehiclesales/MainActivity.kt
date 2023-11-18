package com.febrian.vehiclesales

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
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
import androidx.navigation.compose.rememberNavController
import com.febrian.vehiclesales.ui.components.OrderSection
import com.febrian.vehiclesales.ui.navigation.BottomNavigationBar
import com.febrian.vehiclesales.ui.navigation.NavigationSetup
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

    @RequiresApi(Build.VERSION_CODES.O)
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

                    val navController = rememberNavController()

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
                    }, bottomBar = { BottomNavigationBar(navController) }) { padding ->

                        NavigationSetup(
                            navController = navController
                        )

                    }

                }
            }
        }
    }
}
