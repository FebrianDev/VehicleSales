package com.febrian.vehiclesales.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.febrian.vehiclesales.utils.TypeVehicle

@Composable
fun OrderSection(
    modifier: Modifier = Modifier,
    typeVehicle: TypeVehicle,
    onTypeVehicle: (TypeVehicle) -> Unit
) {
    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            DefaultRadioButton(
                text = "All",
                selected = typeVehicle == TypeVehicle.All,
                onSelect = { onTypeVehicle.invoke(TypeVehicle.All) }
            )
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(
                text = "Car",
                selected = typeVehicle == TypeVehicle.Car,
                onSelect = { onTypeVehicle.invoke(TypeVehicle.Car) }
            )
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(
                text = "Motor",
                selected = typeVehicle == TypeVehicle.MotorCycle,
                onSelect = { onTypeVehicle.invoke(TypeVehicle.MotorCycle) }
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

    }
}