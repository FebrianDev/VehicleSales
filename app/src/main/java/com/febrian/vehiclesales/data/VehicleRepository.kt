package com.febrian.vehiclesales.data

import com.febrian.vehiclesales.data.database.VehicleDao
import com.febrian.vehiclesales.data.entity.Car
import com.febrian.vehiclesales.data.entity.MotorCycle
import com.febrian.vehiclesales.data.entity.Vehicle
import kotlinx.coroutines.flow.Flow

class VehicleRepository (private val vehicleDao: VehicleDao) {

    suspend fun insertVehicle(car: Car){
        vehicleDao.insertVehicle(car)
    }

    suspend fun insertVehicle(motorCycle: MotorCycle){
        vehicleDao.insertVehicle(motorCycle)
    }

    fun getAllVehicle() : Flow<List<Vehicle>>{
        return vehicleDao.getAllVehicle()
    }
}