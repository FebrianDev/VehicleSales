package com.febrian.vehiclesales.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.febrian.vehiclesales.data.entity.Car
import com.febrian.vehiclesales.data.entity.MotorCycle
import com.febrian.vehiclesales.data.entity.SaleCar
import com.febrian.vehiclesales.data.entity.SaleMotorCycle
import com.febrian.vehiclesales.data.entity.SaleWithCar
import com.febrian.vehiclesales.data.entity.SaleWithMotor
import kotlinx.coroutines.flow.Flow

@Dao
interface VehicleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCars(cars: List<Car>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMotorCycles(motorCycles: List<MotorCycle>)

    @Query("DELETE FROM car")
    suspend fun deleteAllCars()

    @Query("DELETE FROM motorcycle")
    suspend fun deleteAllMotorCycles()

    @Query("SELECT * FROM car where isPurchased=:isPurchased")
    fun getAllCars(isPurchased: Boolean): Flow<List<Car>>

    @Query("SELECT * FROM motorcycle where isPurchased=:isPurchased")
    fun getAllMotorCycles(isPurchased: Boolean): Flow<List<MotorCycle>>

    @Query("SELECT * FROM car where id=:id")
    fun getCarById(id: Int): Flow<Car>

    @Query("SELECT * FROM motorcycle where id=:id")
    fun getMotorCycleById(id: Int): Flow<MotorCycle>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun buyCar(sale: SaleCar)

    @Update
    suspend fun buyCar(car: Car)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun buyMotor(sale: SaleMotorCycle)

    @Update
    suspend fun buyMotor(motorCycle: MotorCycle)

    @Transaction
    @Query("SELECT * FROM salecar")
    fun getReceiptSaleCar(): Flow<List<SaleWithCar>>

    @Transaction
    @Query("SELECT * FROM salemotorcycle")
    fun getReceiptSaleMotor(): Flow<List<SaleWithMotor>>

    @Query("DELETE FROM salecar")
    suspend fun deleteAllSaleCar()

    @Query("DELETE FROM salemotorcycle")
    suspend fun deleteAllSaleMotorCycles()
}