package com.febrian.vehiclesales.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.febrian.vehiclesales.data.entity.Car
import com.febrian.vehiclesales.data.entity.MotorCycle
import com.febrian.vehiclesales.data.entity.SaleCar
import com.febrian.vehiclesales.data.entity.SaleMotorCycle

@Database(
    entities = [Car::class, MotorCycle::class, SaleCar::class, SaleMotorCycle::class],
    version = 1,
    exportSchema = false
)
abstract class VehicleDatabase : RoomDatabase() {

    abstract val vehicleDao: VehicleDao
}