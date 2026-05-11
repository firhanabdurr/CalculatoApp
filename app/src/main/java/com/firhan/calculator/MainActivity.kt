package com.firhan.calculator
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.firhan.calculator.core.di.AppContainer
import com.firhan.calculator.feature.calculator.presentation.CalculatorViewModel
import com.firhan.calculator.feature.calculator.presentation.CalculatorScreen
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val appContainer = AppContainer()

        setContent {
            val viewModel: CalculatorViewModel = viewModel(
                factory = CalculatorViewModel.provideFactory(appContainer)
            )

            val state by viewModel.state.collectAsState()

            CalculatorScreen(
                state = state,
                onEvent = viewModel::onEvent
            )
        }
    }
}