package com.febrian.vehiclesales.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.febrian.vehiclesales.data.VehicleRepository
import com.febrian.vehiclesales.data.entity.Car
import com.febrian.vehiclesales.data.entity.MotorCycle
import com.febrian.vehiclesales.data.entity.SaleCar
import com.febrian.vehiclesales.data.entity.SaleMotorCycle
import com.febrian.vehiclesales.data.entity.SaleWithCar
import com.febrian.vehiclesales.data.entity.SaleWithMotor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
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

    private var _getReceiptSaleCar = MutableStateFlow<List<SaleWithCar>>(listOf())
    val getReceiptSaleCar: StateFlow<List<SaleWithCar>> get() = _getReceiptSaleCar

    private var _getReceiptSaleMotor = MutableStateFlow<List<SaleWithMotor>>(listOf())
    val getReceiptSaleMotor: StateFlow<List<SaleWithMotor>> get() = _getReceiptSaleMotor

    private var _getCarById = MutableStateFlow(Car())
    val getCarById: StateFlow<Car> get() = _getCarById

    private var _getMotorById = MutableStateFlow(MotorCycle())
    val getMotorById: StateFlow<MotorCycle> get() = _getMotorById

    fun insertAllVehicles() {
        viewModelScope.launch {
            repository.insertCars()
            repository.insertMotorCycles()
        }
    }

    fun getAllCars(isPurchased: Boolean) {
        viewModelScope.launch {
            repository.getAllCars(isPurchased).onEach {
                _getCars.value = it
            }.stateIn(this, SharingStarted.Eagerly, listOf())
        }
    }

    fun getAllMotorCycles(isPurchased: Boolean) {
        viewModelScope.launch {
            repository.getAllMotorCycles(isPurchased).onEach {
                _getMotorCycles.value = it
            }.stateIn(this, SharingStarted.Eagerly, listOf())
        }
    }

    fun getCarById(id: Int) {
        viewModelScope.launch {
            repository.getCarById(id).onEach {
                println("CAR2"+it)
                _getCarById.value = it
            }.stateIn(this, SharingStarted.Eagerly, Car())
        }
    }

    fun getMotorCycleById(id: Int) {
        viewModelScope.launch {
            repository.getMotorCycleById(id).onEach {
                _getMotorById.value = it
            }.stateIn(this, SharingStarted.Eagerly, Car())
        }
    }

    fun deleteAllVehicles() {
        viewModelScope.launch {
            repository.deleteAllCars()
            repository.deleteAllMotorCycles()
            repository.deleteAllSaleCar()
            repository.deleteAllSaleMotorCycles()
        }
    }

    fun buyCar(saleCar: SaleCar, car: Car) {
        viewModelScope.launch {
            repository.buyCar(saleCar, car)
        }
    }

    fun buyMotor(saleMotorCycle: SaleMotorCycle, motorCycle: MotorCycle) {
        viewModelScope.launch {
            repository.buyMotor(saleMotorCycle, motorCycle)
        }
    }

    fun getReceiptSaleCar() {
        viewModelScope.launch {
            repository.getReceiptSaleCar().onEach {
                _getReceiptSaleCar.value = it
            }.stateIn(this, SharingStarted.Eagerly, listOf())
        }
    }

    fun getReceiptSaleMotor() {
        viewModelScope.launch {
            repository.getReceiptSaleMotor().onEach {
                _getReceiptSaleMotor.value = it
            }.stateIn(this, SharingStarted.Eagerly, listOf())
        }
    }

}