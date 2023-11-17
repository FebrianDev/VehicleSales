package com.febrian.vehiclesales.utils

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
            color = 0xFF0000,
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
            color = 0x00FF00,
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
            color = 0x0000FF,
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
            color = 0xFF0000,
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
            color = 0x00FF00,
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
            color = 0x0000FF,
            price = 12000
        )
    )


    return dummyMotorCycles
}