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
            year = 2020,
            color = 0x0000FF,
            price = 20000
        )
    )

    // Add more dummy data
    dummyCars.add(
        Car(
            machine = "EngineD",
            capacity = 1800,
            type = "Coupe",
            year = 2023,
            color = 0xFFFF00,
            price = 35000
        )
    )
    dummyCars.add(
        Car(
            machine = "EngineE",
            capacity = 2200,
            type = "Convertible",
            year = 2021,
            color = 0x00FFFF,
            price = 40000
        )
    )
    dummyCars.add(
        Car(
            machine = "EngineF",
            capacity = 1900,
            type = "Electric",
            year = 2022,
            color = 0xFF00FF,
            price = 30000
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
            year = 2020,
            color = 0x0000FF,
            price = 12000
        )
    )

    dummyMotorCycles.add(
        MotorCycle(
            machine = "EngineW",
            suspensionType = "Inverted Fork",
            transmissionType = "Manual",
            year = 2023,
            color = 0xFFFF00,
            price = 20000
        )
    )
    dummyMotorCycles.add(
        MotorCycle(
            machine = "EngineV",
            suspensionType = "Dual Shock",
            transmissionType = "Automatic",
            year = 2022,
            color = 0x00FFFF,
            price = 17000
        )
    )
    dummyMotorCycles.add(
        MotorCycle(
            machine = "EngineU",
            suspensionType = "Upside-down Fork",
            transmissionType = "Manual",
            year = 2021,
            color = 0xFF00FF,
            price = 16000
        )
    )

    return dummyMotorCycles
}