package com.febrian.vehiclesales.utils

import java.text.SimpleDateFormat
import java.util.Date

fun dateToString(date: Date): String {
    val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    return sdf.format(date)
}