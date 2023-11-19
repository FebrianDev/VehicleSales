package com.febrian.vehiclesales.ui.item

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.febrian.vehiclesales.data.entity.SaleWithMotor
import com.febrian.vehiclesales.ui.components.TextBodyNormal
import com.febrian.vehiclesales.ui.components.TextBodySmall
import com.febrian.vehiclesales.ui.components.TextSubtitleSmall

@Composable
fun ItemReceiptMotor(sale: SaleWithMotor) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            TextSubtitleSmall(text = sale.motorCycle.name)
            TextBodySmall(text = sale.saleMotorCycle.date)
        }

        TextBodyNormal(text = sale.motorCycle.price.toString())
    }
}