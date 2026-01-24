package com.example.calculatetip

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculatetip.ui.theme.CalculateTipTheme
import java.text.NumberFormat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculateTipTheme {
                CalculateTipApp()
            }
        }
    }
}

@Composable
fun CalculateTipApp() {

    var BillAmount by remember { mutableStateOf("") }
    var TipPercent by remember { mutableStateOf("") }
    var RoundUp by remember { mutableStateOf(false) }

    val amount = BillAmount.toDoubleOrNull() ?: 0.0
    val per = TipPercent.toDoubleOrNull() ?: 0.0
    var roundUp = RoundUp
    var tip = calculateTip(amount, per,roundUp )

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center

    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(50.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Calculate Tip",
                modifier = Modifier.padding(bottom = 15.dp, start = 10.dp),
                fontSize = 16.sp,
                textAlign = TextAlign.Left
            )

            TextField(
                value = BillAmount,
                onValueChange = { BillAmount = it },
                label = { Text(text = "Bill Amount") },
                modifier = Modifier.padding(start = 10.dp),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                leadingIcon = { Icon(
                    painter = painterResource(R.drawable.money_icon),
                    contentDescription = "money",
                    modifier = Modifier.size(20.dp),
                    tint = Color.Unspecified
                    )
                }
            )
            Spacer(modifier = Modifier.height(20.dp))

            TextField(
                value = TipPercent,
                onValueChange = { TipPercent = it },
                label = { Text(text = "Tip Percentage") },
                modifier = Modifier.padding(start = 10.dp),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                ),
                leadingIcon = { Icon(
                    painter = painterResource(R.drawable.percantage_icon),
                    contentDescription = "percantage",
                    modifier = Modifier.size(20.dp),
                    tint = Color.Unspecified
                    )
                }
            )

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Round Up Tip ?",
                    fontSize = 18.sp
                    )

                Switch(
                    checked = RoundUp,
                    onCheckedChange = { RoundUp = it },
                    modifier = Modifier.scale(.8f)
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Tip Amount: $tip",
                modifier = Modifier.fillMaxWidth()
                    .padding(start = 10.dp),
                fontSize = 32.sp,
                fontWeight = FontWeight.ExtraBold
            )
        }
    }
}
@VisibleForTesting
internal fun calculateTip(
    amount: Double,
    tipPercent: Double,
    roundUp: Boolean
    ): String {
    var tip = tipPercent / 100 * amount
            if (roundUp) {
              tip = kotlin.math.ceil(tip)
        }
    return NumberFormat.getCurrencyInstance().format(tip)
}


@Preview(showSystemUi = true)
@Composable
fun CalculateTipAppPreview() {
    CalculateTipApp()
}
