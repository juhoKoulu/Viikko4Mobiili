package com.example.costofelectricity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.costofelectricity.ui.theme.CostOfElectricityTheme
import com.example.costofelectricity.ui.screens.CostOfElectricity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CostOfElectricityTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CostOfElectricity(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}