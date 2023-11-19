package com.febrian.vehiclesales.ui.item

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.febrian.vehiclesales.data.entity.SaleWithCar
import com.febrian.vehiclesales.ui.components.TextBodyNormal
import com.febrian.vehiclesales.ui.components.TextBodySmall
import com.febrian.vehiclesales.ui.components.TextSubtitleSmall

@Composable
fun ItemReceiptCar(sale: SaleWithCar) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            TextSubtitleSmall(text = sale.car.name)
            TextBodySmall(text = sale.sale.date)
        }

        TextBodyNormal(text = sale.car.price.toString())
    }
}