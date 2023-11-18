package com.febrian.vehiclesales.data.entity

import androidx.room.Embedded
import androidx.room.Relation

data class SaleWithCar(
    @Embedded val sale: SaleCar,
    @Relation(
        parentColumn = "carId",
        entityColumn = "id"
    )
    val car: Car,
)
