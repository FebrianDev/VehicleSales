package com.febrian.vehiclesales.ui.components

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ButtonComposable(
    textButton : String = "",
    enabled: Boolean = true,
    modifier: Modifier = Modifier,
    onBuy : () -> Unit
) {
    Button(onClick = onBuy, enabled = enabled, modifier = modifier) {
        Text(text = textButton)
    }
}