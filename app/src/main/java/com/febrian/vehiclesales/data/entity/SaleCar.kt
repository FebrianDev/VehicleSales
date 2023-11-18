package com.febrian.vehiclesales.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = Car::class,
            parentColumns = ["id"],
            childColumns = ["carId"]
        ),

    ]
)
data class SaleCar(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    var carId: Int = 0,
    var date: String = ""
)
