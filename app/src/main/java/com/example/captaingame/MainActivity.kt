package com.example.captaingame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.captaingame.ui.theme.CaptainGameTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CaptainGameTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                )
                { innerPadding ->
                    CaptainGame(innerPadding)
                }
            }
        }
    }
}

@Composable
fun CaptainGame(innerPadding: PaddingValues = PaddingValues()) {
    val treasuresFound = remember { mutableStateOf(0) }
    val direction = remember { mutableStateOf("North") }
    val stormOrTreasure = remember { mutableStateOf("") }

    Column {
        Text(text = "Treasures Found:  ${treasuresFound.value}")
        Text(text = "Current Direction:  ${direction.value}")
        Text(text = " ${stormOrTreasure.value}")
        Button(onClick = {
            direction.value = "East"
            if (Random.nextBoolean()) {
                treasuresFound.value += 1
                stormOrTreasure.value = "WE FOUND A TREASURE!!!"
            } else {
                stormOrTreasure.value = "STORM AHEAD!!!"
            }
        }) {
            Text("Sail East")
        }
        Button(onClick = {
            direction.value = "West"
            if (Random.nextBoolean()) {
                treasuresFound.value += 1
                stormOrTreasure.value = "WE FOUND A TREASURE!!!"
            } else {
                stormOrTreasure.value = "STORM AHEAD!!!"
            }
        }) {
            Text("Sail West")
        }
        Button(onClick = {
            direction.value = "North"
            if (Random.nextBoolean()) {
                treasuresFound.value += 1
                stormOrTreasure.value = "WE FOUND A TREASURE!!!"
            } else {
                stormOrTreasure.value = "STORM AHEAD!!!"
            }
        }) {
            Text("Sail North")
        }
        Button(onClick = {
            direction.value = "South"
            if (Random.nextBoolean()) {
                treasuresFound.value += 1
                stormOrTreasure.value = "WE FOUND A TREASURE!!!"
            } else {
                stormOrTreasure.value = "STORM AHEAD!!!"
            }
        }) {
            Text("Sail South")
        }
    }
}
