package com.firhan.calculator.feature.calculator.presentation

import com.firhan.calculator.feature.calculator.presentation.component.CalculatorButton

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.firhan.calculator.feature.calculator.domain.model.CalculatorOperation

@Composable
fun CalculatorScreen(
    state: CalculatorUiState,
    onEvent: (CalculatorEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    val buttonSpacing = 8.dp

//    // 2. Deteksi orientasi layar saat ini
//    val configuration = LocalConfiguration.current
//    val isLandscape = configuration.orientation == Configuration.ORIENTATION_LANDSCAPE
//
//    // 3. Sesuaikan jarak dan ukuran font otomatis
//    val buttonSpacing = if (isLandscape) 4.dp else 8.dp
//    val displayFontSize = if (isLandscape) 48.sp else 80.sp

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp),
        verticalArrangement = Arrangement.Bottom
    ) {
        // --- DISPLAY AREA ---
        Text(
            text = state.number1 + (state.operation?.symbol ?: "") + state.number2,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 32.dp),
            textAlign = TextAlign.End,
            fontWeight = FontWeight.Light,
            fontSize = 80.sp,
            color = Color.White,
            maxLines = 2
        )

        // --- BUTTON GRID ---
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            CalculatorButton(
                symbol = "AC",
                backgroundColor = Color.LightGray,
                textColor = Color.Black,
                modifier = Modifier
                    .aspectRatio(2f)
                    .weight(2f),
                onClick = { onEvent(CalculatorEvent.Clear) }
            )
            CalculatorButton(
                symbol = "DEL",
                backgroundColor = Color.LightGray,
                textColor = Color.Black,
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                onClick = { onEvent(CalculatorEvent.Delete) }
            )
            CalculatorButton(
                symbol = "÷",
                backgroundColor = Color(0xFFFF9800),
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                onClick = { onEvent(CalculatorEvent.Operation(CalculatorOperation.Divide)) }
            )
        }
        Spacer(modifier = Modifier.height(buttonSpacing))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            CalculatorButton(
                symbol = "7",
                modifier = Modifier.aspectRatio(1f).weight(1f),
                onClick = { onEvent(CalculatorEvent.Number(7)) }
            )
            CalculatorButton(
                symbol = "8",
                modifier = Modifier.aspectRatio(1f).weight(1f),
                onClick = { onEvent(CalculatorEvent.Number(8)) }
            )
            CalculatorButton(
                symbol = "9",
                modifier = Modifier.aspectRatio(1f).weight(1f),
                onClick = { onEvent(CalculatorEvent.Number(9)) }
            )
            CalculatorButton(
                symbol = "×",
                backgroundColor = Color(0xFFFF9800),
                modifier = Modifier.aspectRatio(1f).weight(1f),
                onClick = { onEvent(CalculatorEvent.Operation(CalculatorOperation.Multiply)) }
            )
        }
        Spacer(modifier = Modifier.height(buttonSpacing))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            CalculatorButton(
                symbol = "4",
                modifier = Modifier.aspectRatio(1f).weight(1f),
                onClick = { onEvent(CalculatorEvent.Number(4)) }
            )
            CalculatorButton(
                symbol = "5",
                modifier = Modifier.aspectRatio(1f).weight(1f),
                onClick = { onEvent(CalculatorEvent.Number(5)) }
            )
            CalculatorButton(
                symbol = "6",
                modifier = Modifier.aspectRatio(1f).weight(1f),
                onClick = { onEvent(CalculatorEvent.Number(6)) }
            )
            CalculatorButton(
                symbol = "-",
                backgroundColor = Color(0xFFFF9800),
                modifier = Modifier.aspectRatio(1f).weight(1f),
                onClick = { onEvent(CalculatorEvent.Operation(CalculatorOperation.Subtract)) }
            )
        }
        Spacer(modifier = Modifier.height(buttonSpacing))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            CalculatorButton(
                symbol = "1",
                modifier = Modifier.aspectRatio(1f).weight(1f),
                onClick = { onEvent(CalculatorEvent.Number(1)) }
            )
            CalculatorButton(
                symbol = "2",
                modifier = Modifier.aspectRatio(1f).weight(1f),
                onClick = { onEvent(CalculatorEvent.Number(2)) }
            )
            CalculatorButton(
                symbol = "3",
                modifier = Modifier.aspectRatio(1f).weight(1f),
                onClick = { onEvent(CalculatorEvent.Number(3)) }
            )
            CalculatorButton(
                symbol = "+",
                backgroundColor = Color(0xFFFF9800),
                modifier = Modifier.aspectRatio(1f).weight(1f),
                onClick = { onEvent(CalculatorEvent.Operation(CalculatorOperation.Add)) }
            )
        }
        Spacer(modifier = Modifier.height(buttonSpacing))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            CalculatorButton(
                symbol = "0",
                modifier = Modifier
                    .aspectRatio(2f)
                    .weight(2f),
                onClick = { onEvent(CalculatorEvent.Number(0)) }
            )
            CalculatorButton(
                symbol = ".",
                modifier = Modifier.aspectRatio(1f).weight(1f),
                onClick = { onEvent(CalculatorEvent.Decimal) }
            )
            CalculatorButton(
                symbol = "=",
                backgroundColor = Color(0xFFFF9800),
                modifier = Modifier.aspectRatio(1f).weight(1f),
                onClick = { onEvent(CalculatorEvent.Calculate) }
            )
        }
    }
}