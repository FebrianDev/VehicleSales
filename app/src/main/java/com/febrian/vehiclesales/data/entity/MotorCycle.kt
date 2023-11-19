package com.febrian.vehiclesales.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MotorCycle(
    @PrimaryKey(autoGenerate = true) override var id: Int = 0,
    var machine: String = "",
    var suspensionType: String = "",
    var transmissionType: String = "",
    override var name: String = "",
    override var year: Int = 0,
    override var color: Int = 0,
    override var price: Int = 0
) : Vehicle(id, name, year, color, price)