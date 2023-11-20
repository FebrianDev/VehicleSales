package com.febrian.vehiclesales.ui.item

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.febrian.vehiclesales.data.entity.SaleWithCar
import com.febrian.vehiclesales.ui.components.TextBodyNormal
import com.febrian.vehiclesales.ui.components.TextBodySmall
import com.febrian.vehiclesales.ui.components.TextSubtitleSmall

@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@Composable
fun ItemReceiptCar(sale: SaleWithCar) {

    val sheetState = rememberModalBottomSheetState()
    var showBottomSheet by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                showBottomSheet = true
            },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            TextSubtitleSmall(text = sale.car.name)
            TextBodySmall(text = sale.sale.date)
        }

        TextBodyNormal(text = sale.car.price.toString())
    }

    if (showBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = {
                showBottomSheet = false
            },
            sheetState = sheetState
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                TextSubtitleSmall(text = sale.car.name)
                TextBodyNormal(text = "${sale.car.machine} | ${sale.car.type} | ${sale.car.capacity}")
                Row(modifier = Modifier.padding(top = 2.dp)) {
                    Box(
                        modifier = Modifier
                            .size(24.dp)
                            .background(color = Color(sale.car.color))
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    TextBodyNormal(text = "Color")
                }
                TextBodyNormal(text = "Price: ${sale.car.price}")
                TextBodyNormal(text = "Year: ${sale.car.year}")
                Spacer(modifier = Modifier.width(8.dp))
                TextBodyNormal(text = "Date Transaction : ${sale.sale.date}")
            }

        }
    }
}