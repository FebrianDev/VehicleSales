package com.febrian.vehiclesales.ui.screen

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.febrian.vehiclesales.ui.components.TextTitleLarge
import com.febrian.vehiclesales.ui.item.ItemReceiptCar
import com.febrian.vehiclesales.ui.item.ItemReceiptMotor

@Composable
fun ReceiptScreen(
    vehicleViewModel: VehicleViewModel = hiltViewModel()
) {

    //  vehicleViewModel.getReceipt()
    vehicleViewModel.getReceiptSaleCar()
    vehicleViewModel.getReceiptSaleMotor()

    val listSaleCar = vehicleViewModel.getReceiptSaleCar.collectAsState().value
    val listSaleMotorCycle = vehicleViewModel.getReceiptSaleMotor.collectAsState().value

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {

        item {
            TextTitleLarge(text = "Sale Receipt")
            Spacer(modifier = Modifier.height(16.dp))
        }

        items(listSaleCar) {
            ItemReceiptCar(it)
        }

        items(listSaleMotorCycle) {
            ItemReceiptMotor(it)
        }
    }
}