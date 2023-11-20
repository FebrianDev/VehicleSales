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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.febrian.vehiclesales.R
import com.febrian.vehiclesales.data.entity.MotorCycle
import com.febrian.vehiclesales.ui.components.ButtonComposable

@Composable
fun ItemMotorCycle(
    textButton: String,
    motorCycle: MotorCycle,
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
                painter = painterResource(id = R.drawable.motor),
                contentDescription = "MotorCycle",
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
                    Text(
                        motorCycle.name,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        "${motorCycle.machine} | ${motorCycle.transmissionType} | ${motorCycle.year}",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Center
                    )

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