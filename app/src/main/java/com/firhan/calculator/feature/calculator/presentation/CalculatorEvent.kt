package com.firhan.calculator.feature.calculator.presentation

import com.firhan.calculator.feature.calculator.domain.model.CalculatorOperation

sealed interface CalculatorEvent {
    data class Number(val number: Int) : CalculatorEvent
    data class Operation(val operation: CalculatorOperation) : CalculatorEvent
    object Decimal : CalculatorEvent
    object Clear : CalculatorEvent
    object Delete : CalculatorEvent
    object Calculate : CalculatorEvent
}