package com.febrian.vehiclesales.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.febrian.vehiclesales.data.entity.Car
import com.febrian.vehiclesales.data.entity.MotorCycle

@Database(entities = [Car::class, MotorCycle::class], version = 2)
abstract class VehicleDatabase : RoomDatabase() {

    abstract val vehicleDao: VehicleDao
}