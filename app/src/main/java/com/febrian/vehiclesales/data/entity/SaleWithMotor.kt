package com.febrian.vehiclesales.data.entity

import androidx.room.Embedded
import androidx.room.Relation

data class SaleWithMotor(
    @Embedded val saleMotorCycle: SaleMotorCycle, @Relation(
        parentColumn = "motorCycleId", entityColumn = "id"
    ) val motorCycle: MotorCycle
)
