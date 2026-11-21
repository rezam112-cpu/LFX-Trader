
package com.lfxtrader.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LFXTraderApp()
        }
    }
}

@Composable
fun LFXTraderApp() {
    var selected by remember { mutableStateOf("XAUUSD") }

    val background = Color(0xFF101820)
    val panel = Color(0xFF1B2836)
    val green = Color(0xFF00C087)
    val red = Color(0xFFFF5364)

    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(background)
                .padding(16.dp)
        ) {
            Text(
                "LFX TRADER",
                color = Color.White,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                "Professional Trading Terminal",
                color = Color.Gray,
                fontSize = 12.sp
            )

            Spacer(Modifier.height(24.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                listOf("XAUUSD", "EURUSD", "GBPUSD").forEach {
                    Button(
                        onClick = { selected = it },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (selected == it) green else panel
                        )
                    ) {
                        Text(it, color = Color.White)
                    }
                }
            }

            Spacer(Modifier.height(20.dp))

            Card(
                colors = CardDefaults.cardColors(containerColor = panel),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(Modifier.padding(18.dp)) {
                    Text(selected, color = Color.White, fontSize = 20.sp)
                    Spacer(Modifier.height(8.dp))
                    Text(
                        if (selected == "XAUUSD") "Gold / US Dollar"
                        else "Forex Market",
                        color = Color.Gray
                    )
                    Spacer(Modifier.height(12.dp))
                    Text(
                        "DEMO PRICE",
                        color = Color.Gray,
                        fontSize = 12.sp
                    )
                    Text(
                        "2,650.00",
                        color = green,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        "Demo display only - not live market data",
                        color = Color.Yellow,
                        fontSize = 11.sp
                    )
                }
            }

            Spacer(Modifier.height(18.dp))

            Card(
                colors = CardDefaults.cardColors(containerColor = panel),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(210.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text("CHART", color = Color.Gray, fontSize = 13.sp)
                    Spacer(Modifier.height(12.dp))
                    Text(
                        "Trading chart will appear here",
                        color = Color.White
                    )
                    Text(
                        "M1     M5     M15     H1     H4     D1",
                        color = green,
                        modifier = Modifier.padding(top = 18.dp)
                    )
                }
            }

            Spacer(Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Button(
                    onClick = {},
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = green
                    ),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text("BUY", color = Color.White, fontSize = 18.sp)
                }

                Button(
                    onClick = {},
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = red
                    ),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text("SELL", color = Color.White, fontSize = 18.sp)
                }
            }

            Spacer(Modifier.height(22.dp))

            Text("ACCOUNT", color = Color.Gray)
            Spacer(Modifier.height(8.dp))
            Text("Demo Account", color = Color.White, fontSize = 17.sp)
            Text("Balance: 10,000 USD", color = green, fontSize = 20.sp)

            Spacer(Modifier.weight(1f))

            Text(
                "LFX Trader v0.1 | Demo mode",
                color = Color.Gray,
                fontSize = 11.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}
