package com.febrian.vehiclesales.data

import com.febrian.vehiclesales.data.database.VehicleDao
import com.febrian.vehiclesales.data.entity.Car
import com.febrian.vehiclesales.data.entity.MotorCycle
import com.febrian.vehiclesales.data.entity.SaleCar
import com.febrian.vehiclesales.data.entity.SaleMotorCycle
import com.febrian.vehiclesales.data.entity.SaleWithCar
import com.febrian.vehiclesales.data.entity.SaleWithMotor
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

    fun getAllCars(isPurchased: Boolean): Flow<List<Car>> {
        return vehicleDao.getAllCars(isPurchased)
    }

    fun getAllMotorCycles(isPurchased: Boolean): Flow<List<MotorCycle>> {
        return vehicleDao.getAllMotorCycles(isPurchased)
    }

    fun getCarById(id: Int): Flow<Car> {
        return vehicleDao.getCarById(id)
    }

    fun getMotorCycleById(id: Int): Flow<MotorCycle> {
        return vehicleDao.getMotorCycleById(id)
    }

    suspend fun deleteAllCars() {
        vehicleDao.deleteAllCars()
    }

    suspend fun deleteAllMotorCycles() {
        vehicleDao.deleteAllMotorCycles()
    }

    suspend fun buyCar(saleCar: SaleCar, car: Car) {
        vehicleDao.buyCar(saleCar)
        vehicleDao.buyCar(car)
    }

    suspend fun buyMotor(saleMotor: SaleMotorCycle, motorCycle: MotorCycle) {
        vehicleDao.buyMotor(saleMotor)
        vehicleDao.buyMotor(motorCycle)
    }

    fun getReceiptSaleCar(): Flow<List<SaleWithCar>> {
        return vehicleDao.getReceiptSaleCar()
    }

    fun getReceiptSaleMotor(): Flow<List<SaleWithMotor>> {
        return vehicleDao.getReceiptSaleMotor()
    }

    suspend fun deleteAllSaleCar() {
        vehicleDao.deleteAllSaleCar()
    }

    suspend fun deleteAllSaleMotorCycles() {
        vehicleDao.deleteAllSaleMotorCycles()
    }
}