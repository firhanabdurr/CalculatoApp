package com.firhan.calculator.feature.calculator.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.firhan.calculator.core.di.AppContainer
import com.firhan.calculator.feature.calculator.domain.usecase.CalculateResultUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class CalculatorViewModel(
    private val calculateResultUseCase: CalculateResultUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(CalculatorUiState())
    val state = _state.asStateFlow()

    fun onEvent(event: CalculatorEvent) {
        when (event) {
            is CalculatorEvent.Number -> {}
            is CalculatorEvent.Operation -> {}
            CalculatorEvent.Calculate -> {}
            CalculatorEvent.Clear -> {}
            CalculatorEvent.Decimal -> {}
            CalculatorEvent.Delete -> {}
        }
    }

    companion object {
        fun provideFactory(appContainer: AppContainer): ViewModelProvider.Factory = viewModelFactory {
            initializer {
                CalculatorViewModel(
                    calculateResultUseCase = appContainer.calculateResultUseCase
                )
            }
        }
    }
}