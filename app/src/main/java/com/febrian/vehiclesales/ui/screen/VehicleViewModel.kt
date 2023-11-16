package com.febrian.vehiclesales.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.febrian.vehiclesales.data.VehicleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VehicleViewModel @Inject constructor(private val repository: VehicleRepository) :
    ViewModel() {

    fun insertAllVehicles() {
        viewModelScope.launch {
            repository.insertCars()
            repository.insertMotorCycles()
        }
    }

    fun getAllCars() {
        repository.getAllCars().launchIn(viewModelScope)
    }

    fun getAllMotorCycles() {
        repository.getAllMotorCycles().launchIn(viewModelScope)
    }

    fun deleteAllVehicles() {
        viewModelScope.launch {
            repository.deleteAllCars()
            repository.deleteAllMotorCycles()
        }

    }
}