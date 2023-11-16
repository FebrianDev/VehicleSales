package com.febrian.vehiclesales.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.febrian.vehiclesales.data.entity.Car
import com.febrian.vehiclesales.data.entity.MotorCycle
import com.febrian.vehiclesales.data.entity.Vehicle
import kotlinx.coroutines.flow.Flow

@Dao
interface VehicleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCars(cars: List<Car>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMotorCycles(motorCycles: List<MotorCycle>)

    @Query("SELECT * FROM car")
    fun getAllCars(): Flow<List<Car>>

    @Query("SELECT * FROM motorcycle")
    fun getAllMotorCycles(): Flow<List<MotorCycle>>

    @Query("DELETE FROM car")
    suspend fun deleteAllCars()

    @Query("DELETE FROM motorcycle")
    suspend fun deleteAllMotorCycles()
}