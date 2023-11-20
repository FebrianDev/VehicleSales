package com.febrian.vehiclesales.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun TextTitleLarge(text: String, modifier: Modifier = Modifier) {
    Text(
        text,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        modifier = modifier
    )
}

@Composable
fun TextSubtitleMedium(text: String, modifier: Modifier = Modifier) {
    Text(
        text,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        modifier = modifier
    )
}

@Composable
fun TextSubtitleSmall(text: String, modifier: Modifier = Modifier) {
    Text(
        text,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        modifier = modifier
    )
}

@Composable
fun TextBodyNormal(text: String, modifier: Modifier = Modifier) {
    Text(
        text,
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        modifier = modifier
    )
}

@Composable
fun TextBodySmall(text: String, modifier: Modifier = Modifier) {
    Text(
        text,
        fontSize = 12.sp,
        fontWeight = FontWeight.Light,
        modifier = modifier
    )
}