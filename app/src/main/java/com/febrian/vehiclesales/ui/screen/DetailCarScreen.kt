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
import androidx.compose.material.icons.filled.ArrowBackIos
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.febrian.vehiclesales.R
import com.febrian.vehiclesales.data.entity.SaleCar
import com.febrian.vehiclesales.ui.components.ButtonComposable
import com.febrian.vehiclesales.ui.components.TextBodyNormal
import com.febrian.vehiclesales.ui.components.TextSubtitleMedium
import com.febrian.vehiclesales.ui.components.TextSubtitleSmall
import com.febrian.vehiclesales.utils.dateToString
import java.util.Date

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DetailCarScreen(
    id: Int = 0,
    vehicleViewModel: VehicleViewModel = hiltViewModel(),
    navController: NavController = rememberNavController()
) {

    vehicleViewModel.getCarById(id)

    val car = vehicleViewModel.getCarById.collectAsState().value

    var isPurchased by remember { mutableStateOf(false) }
    isPurchased = car.isPurchased

    Column(modifier = Modifier.padding(16.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Filled.ArrowBackIos,
                "Arrow Back",
                tint = Color.Black,
                modifier = Modifier.clickable {
                    navController.popBackStack()
                })

            TextSubtitleMedium(text = "Detail Car Screen")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = painterResource(id = R.drawable.car),
            contentDescription = "Car",
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp))
        )

        Spacer(modifier = Modifier.height(24.dp))

        TextSubtitleSmall(text = car.name)
        TextBodyNormal(text = "${car.machine} | ${car.type} | ${car.capacity}")

        Row(modifier = Modifier.padding(top = 2.dp)) {
            Box(
                modifier = Modifier
                    .size(24.dp)
                    .background(color = Color(car.color))
            )
            Spacer(modifier = Modifier.width(4.dp))
            TextBodyNormal(text = "Color")
        }

        TextBodyNormal(text = "Price: ${car.price}")
        TextBodyNormal(text = "Year: ${car.year}")

        Spacer(modifier = Modifier.height(8.dp))

        ButtonComposable(textButton = if (isPurchased) "Purchased" else "Buy Car",
            modifier = Modifier.fillMaxWidth(),
            enabled = !isPurchased,
            onBuy = {
                car.isPurchased = true
                isPurchased = true
                vehicleViewModel.buyCar(
                    SaleCar(carId = car.id, date = dateToString(Date())), car
                )
            })
    }
}