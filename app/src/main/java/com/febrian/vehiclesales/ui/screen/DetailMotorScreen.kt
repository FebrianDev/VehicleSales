package com.febrian.vehiclesales.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBackIos
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.febrian.vehiclesales.R
import com.febrian.vehiclesales.data.entity.SaleMotorCycle
import com.febrian.vehiclesales.ui.components.ButtonComposable
import com.febrian.vehiclesales.ui.components.TextBodyNormal
import com.febrian.vehiclesales.ui.components.TextSubtitleMedium
import com.febrian.vehiclesales.ui.components.TextSubtitleSmall
import com.febrian.vehiclesales.utils.dateToString
import java.util.Date

@Composable
fun DetailMotorScreen(
    id: Int = 0,
    vehicleViewModel: VehicleViewModel = hiltViewModel(),
    navController: NavController = rememberNavController()
) {
    vehicleViewModel.getMotorCycleById(id)

    val motor = vehicleViewModel.getMotorById.collectAsState().value
    var isPurchased by remember { mutableStateOf(false) }
    isPurchased = motor.isPurchased

    Column(modifier = Modifier.padding(16.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                Icons.AutoMirrored.Filled.ArrowBackIos,
                "Arrow Back",
                tint = Color.Black,
                modifier = Modifier.clickable {
                    navController.popBackStack()
                }
            )

            TextSubtitleMedium(text = "Detail Car Screen")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = painterResource(id = R.drawable.motor),
            contentDescription = "Car",
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp))
        )
        Spacer(modifier = Modifier.height(24.dp))

        TextSubtitleSmall(text = motor.name)
        TextBodyNormal(text = "${motor.machine} | ${motor.transmissionType} | ${motor.suspensionType}")

        Row(modifier = Modifier.padding(top = 2.dp)) {
            Box(
                modifier = Modifier
                    .size(24.dp)
                    .background(color = Color(motor.color))
            )
            Spacer(modifier = Modifier.width(4.dp))
            TextBodyNormal(text = "Color")
        }

        TextBodyNormal(text = "Price: ${motor.price}")
        TextBodyNormal(text = "Year: ${motor.year}")

        Spacer(modifier = Modifier.height(8.dp))

        ButtonComposable(
            textButton = if (isPurchased) "Purchased" else "Buy Motor",
            modifier = Modifier.fillMaxWidth(),
            enabled = !isPurchased,
            onBuy = {
                isPurchased = true
                motor.isPurchased = true
                vehicleViewModel.buyMotor(
                    SaleMotorCycle(motorCycleId = motor.id, date = dateToString(Date())),
                    motor
                )
            }
        )
    }
}