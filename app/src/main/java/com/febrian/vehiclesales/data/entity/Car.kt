package com.febrian.vehiclesales.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Car(
    @PrimaryKey(autoGenerate = true) override var id: Int = 0,
    var machine: String = "",
    var capacity: Int = 0,
    var type: String = "",
    override var year: Int = 0,
    override var color: Long = 0L,
    override var price: Int = 0
) : Vehicle(id, year, color, price)