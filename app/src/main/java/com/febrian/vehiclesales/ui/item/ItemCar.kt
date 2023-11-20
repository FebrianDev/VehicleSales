package com.febrian.vehiclesales.ui.item

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.febrian.vehiclesales.R
import com.febrian.vehiclesales.data.entity.Car
import com.febrian.vehiclesales.ui.components.ButtonComposable
import com.febrian.vehiclesales.ui.components.TextBodyNormal
import com.febrian.vehiclesales.ui.components.TextSubtitleSmall

@Composable
fun ItemCar(
    textButton: String,
    car: Car,
    onNavigate: () -> Unit
) {
    Card(
        modifier = Modifier
            .padding(vertical = 16.dp, horizontal = 24.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable(onClick = onNavigate),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {

            Image(
                painter = painterResource(id = R.drawable.car),
                contentDescription = "Car",
                modifier = Modifier
                    .clip(
                        RoundedCornerShape(12.dp)
                    )
                    .fillMaxWidth()
                    .height(196.dp),
                contentScale = ContentScale.Crop
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Column {
                    TextSubtitleSmall(text = car.name)
                    Spacer(modifier = Modifier.height(4.dp))
                    TextBodyNormal(text = "${car.machine} | ${car.type} | ${car.year}")
                }

                ButtonComposable(
                    textButton = textButton,
                    enabled = textButton != "Purchased",
                    onBuy = onNavigate
                )
            }
        }
    }
}