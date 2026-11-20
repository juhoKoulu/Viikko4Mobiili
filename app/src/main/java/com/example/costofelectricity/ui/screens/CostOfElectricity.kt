package com.example.costofelectricity.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

@Composable
fun CostOfElectricity(modifier: Modifier = Modifier) {
    var consumption: String by remember { mutableStateOf("") }
    var cost by remember { mutableStateOf(0f) }
    var vat10 by remember { mutableStateOf(false) }

    Column (
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.padding(8.dp)
    ) {
        Text(
            text="Cost of electricity",
            color = MaterialTheme.colorScheme.primary,
            fontSize = MaterialTheme.typography.titleLarge.fontSize,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Left
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = consumption,
            onValueChange = {consumption = it},
            label = {Text(text = "Consumption in kWh")},
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Text(
            text="Price/kWh $cost",
            color = MaterialTheme.colorScheme.primary,
            fontSize = MaterialTheme.typography.titleLarge.fontSize,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Left
        )
        Slider(
            value = cost,
            onValueChange = { cost = (it * 100).roundToInt() / 100f },
            valueRange = 0f..1f
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = vat10,
                onCheckedChange = { vat10 = it }
            )
            Text("VAT 10%")
        }

        val cosumptionFloat : Float = consumption.toFloatOrNull() ?: 0.0f
        var finalCost : Float = cost * cosumptionFloat
        if (vat10)
            finalCost += finalCost * 0.1f
        else
            finalCost += finalCost * 0.24f

        Text(
            text="Final cost: $finalCost €",
            color = MaterialTheme.colorScheme.primary,
            fontSize = MaterialTheme.typography.titleLarge.fontSize,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Left
        )
    }
}