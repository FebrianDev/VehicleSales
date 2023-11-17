package com.febrian.vehiclesales.ui.screen

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.febrian.vehiclesales.data.VehicleRepository
import com.febrian.vehiclesales.data.entity.Car
import com.febrian.vehiclesales.data.entity.MotorCycle
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VehicleViewModel @Inject constructor(private val repository: VehicleRepository) :
    ViewModel() {

    private var _getCars = MutableStateFlow<List<Car>>(listOf())
    val getCars: StateFlow<List<Car>> get() = _getCars

    private var _getMotorCycles = MutableStateFlow<List<MotorCycle>>(listOf())
    val getMotorCycles: StateFlow<List<MotorCycle>> get() = _getMotorCycles

    fun insertAllVehicles() {
        viewModelScope.launch {
            repository.insertCars()
            repository.insertMotorCycles()
        }
    }

    fun getAllCars() {
        viewModelScope.launch {
            repository.getAllCars().onEach {
                _getCars.value = it
            }.stateIn(this, SharingStarted.Eagerly, listOf())
        }
    }

    fun getAllMotorCycles() {
        viewModelScope.launch {
            repository.getAllMotorCycles().onEach {
                _getMotorCycles.value = it
            }.stateIn(this, SharingStarted.Eagerly, listOf())
        }
    }


    fun deleteAllVehicles() {
        viewModelScope.launch {
            repository.deleteAllCars()
            repository.deleteAllMotorCycles()
        }
    }
}