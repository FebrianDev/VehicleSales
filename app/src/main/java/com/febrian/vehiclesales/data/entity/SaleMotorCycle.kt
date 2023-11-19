package com.febrian.vehiclesales.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.Companion.CASCADE
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [ForeignKey(
        entity = MotorCycle::class, parentColumns = ["id"], childColumns = ["motorCycleId"],
        onDelete = CASCADE
    )]
)
data class SaleMotorCycle(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    var motorCycleId: Int = 0,
    var date: String = ""
)