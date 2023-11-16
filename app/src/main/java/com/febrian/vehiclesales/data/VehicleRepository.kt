package com.febrian.vehiclesales.data

import com.febrian.vehiclesales.data.database.VehicleDao
import com.febrian.vehiclesales.data.entity.Car
import com.febrian.vehiclesales.data.entity.MotorCycle
import com.febrian.vehiclesales.utils.createDummyCarList
import com.febrian.vehiclesales.utils.createDummyMotorCycleList
import kotlinx.coroutines.flow.Flow

class VehicleRepository(private val vehicleDao: VehicleDao) {

    suspend fun insertCars() {
        vehicleDao.insertCars(createDummyCarList())
    }

    suspend fun insertMotorCycles() {
        vehicleDao.insertMotorCycles(createDummyMotorCycleList())
    }

    fun getAllCars(): Flow<List<Car>> {
        return vehicleDao.getAllCars()
    }

    fun getAllMotorCycles(): Flow<List<MotorCycle>> {
        return vehicleDao.getAllMotorCycles()
    }

   suspend fun deleteAllCars() {
        vehicleDao.deleteAllCars()
    }

   suspend fun deleteAllMotorCycles() {
        vehicleDao.deleteAllMotorCycles()
    }
}