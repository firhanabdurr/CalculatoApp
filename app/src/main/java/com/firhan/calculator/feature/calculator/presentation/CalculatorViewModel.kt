package com.firhan.calculator.feature.calculator.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.firhan.calculator.core.di.AppContainer
import com.firhan.calculator.feature.calculator.domain.model.CalculatorOperation
import com.firhan.calculator.feature.calculator.domain.usecase.CalculateResultUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CalculatorViewModel(
    private val calculateResultUseCase: CalculateResultUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(CalculatorUiState())
    val state = _state.asStateFlow()

    companion object {
        private const val MAX_NUM_LENGTH = 15 // Mencegah input angka kepanjangan

        fun provideFactory(appContainer: AppContainer): ViewModelProvider.Factory = viewModelFactory {
            initializer {
                CalculatorViewModel(
                    calculateResultUseCase = appContainer.calculateResultUseCase
                )
            }
        }
    }

    fun onEvent(event: CalculatorEvent) {
        when (event) {
            is CalculatorEvent.Number -> enterNumber(event.number)
            is CalculatorEvent.Operation -> enterOperation(event.operation)
            is CalculatorEvent.Decimal -> enterDecimal()
            is CalculatorEvent.Clear -> _state.value = CalculatorUiState() // Reset total
            is CalculatorEvent.Delete -> performDeletion()
            is CalculatorEvent.Calculate -> performCalculation()
        }
    }

    private fun enterNumber(number: Int) {
        if (_state.value.operation == null) {
            if (_state.value.number1.length >= MAX_NUM_LENGTH) return
            _state.update { it.copy(number1 = it.number1 + number) }
        } else {
            if (_state.value.number2.length >= MAX_NUM_LENGTH) return
            _state.update { it.copy(number2 = it.number2 + number) }
        }
    }

    private fun enterOperation(operation: CalculatorOperation) {
        if (_state.value.number1.isNotBlank()) {
            _state.update { it.copy(operation = operation) }
        }
    }

    private fun enterDecimal() {
        if (_state.value.operation == null && !_state.value.number1.contains(".") && _state.value.number1.isNotBlank()) {
            _state.update { it.copy(number1 = it.number1 + ".") }
        } else if (_state.value.operation != null && !_state.value.number2.contains(".") && _state.value.number2.isNotBlank()) {
            _state.update { it.copy(number2 = it.number2 + ".") }
        }
    }

    private fun performDeletion() {
        when {
            _state.value.number2.isNotBlank() -> _state.update { it.copy(number2 = it.number2.dropLast(1)) }
            _state.value.operation != null -> _state.update { it.copy(operation = null) }
            _state.value.number1.isNotBlank() -> _state.update { it.copy(number1 = it.number1.dropLast(1)) }
        }
    }

    private fun performCalculation() {
        val number1 = _state.value.number1
        val number2 = _state.value.number2
        val operation = _state.value.operation

        if (number1.isNotBlank() && number2.isNotBlank() && operation != null) {
            val result = calculateResultUseCase(number1, number2, operation)

            _state.update {
                it.copy(
                    number1 = result,
                    number2 = "",
                    operation = null
                )
            }
        }
    }
}