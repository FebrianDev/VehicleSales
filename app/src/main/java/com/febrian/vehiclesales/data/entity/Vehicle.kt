package com.febrian.vehiclesales.data.entity

open class Vehicle(
    open var id: Int = 0,
    open var name: String = "",
    open var year: Int = 0,
    open var color: Int = 0,
    open var price: Int = 0,
    open var isPurchased: Boolean = false
)