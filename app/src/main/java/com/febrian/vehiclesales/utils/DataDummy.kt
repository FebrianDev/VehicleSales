package com.febrian.vehiclesales.utils

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import com.febrian.vehiclesales.data.entity.Car
import com.febrian.vehiclesales.data.entity.MotorCycle


fun createDummyCarList(): List<Car> {
    val dummyCars = mutableListOf<Car>()

    dummyCars.add(
        Car(
            machine = "EngineA",
            capacity = 2000,
            type = "Sedan",
            name = "Car A",
            year = 2022,
            color = Color(0xFF000000).toArgb(),
            price = 25000
        )
    )
    dummyCars.add(
        Car(
            machine = "EngineB",
            capacity = 1500,
            type = "SUV",
            name = "Car B",
            year = 2021,
            color = Color(0xFF00FF00).toArgb(),
            price = 30000
        )
    )
    dummyCars.add(
        Car(
            machine = "EngineC",
            capacity = 2500,
            type = "Hatchback",
            name = "Car C",
            year = 2020,
            color = Color(0xFF0000FF).toArgb(),
            price = 20000
        )
    )


    return dummyCars
}

fun createDummyMotorCycleList(): List<MotorCycle> {
    val dummyMotorCycles = mutableListOf<MotorCycle>()

    dummyMotorCycles.add(
        MotorCycle(
            machine = "EngineX",
            suspensionType = "Front Fork",
            transmissionType = "Manual",
            name = "Motor A",
            year = 2022,
            color = Color(0xFF000000).toArgb(),
            price = 15000
        )
    )
    dummyMotorCycles.add(
        MotorCycle(
            machine = "EngineY",
            suspensionType = "Rear Mono-shock",
            transmissionType = "Automatic",
            name = "Motor B",
            year = 2021,
            color = Color(0xFF00FF00).toArgb(),
            price = 18000
        )
    )
    dummyMotorCycles.add(
        MotorCycle(
            machine = "EngineZ",
            suspensionType = "Telescopic",
            transmissionType = "Manual",
            name = "Motor C",
            year = 2020,
            color = Color(0xFF0000FF).toArgb(),
            price = 12000
        )
    )


    return dummyMotorCycles
}