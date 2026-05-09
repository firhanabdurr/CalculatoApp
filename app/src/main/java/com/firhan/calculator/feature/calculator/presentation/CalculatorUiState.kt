package com.firhan.calculator.feature.calculator.presentation

import com.firhan.calculator.feature.calculator.domain.model.CalculatorOperation

data class CalculatorUiState(
    val number1: String = "",
    val number2: String = "",
    val operation: CalculatorOperation? = null,
    val errorMessage: String? = null
)