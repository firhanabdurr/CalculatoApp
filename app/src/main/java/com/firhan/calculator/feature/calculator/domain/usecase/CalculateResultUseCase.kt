package com.firhan.calculator.feature.calculator.domain.usecase

import com.firhan.calculator.feature.calculator.domain.model.CalculatorOperation

class CalculateResultUseCase {

    operator fun invoke(number1: String, number2: String, operation: CalculatorOperation): String {
        val num1 = number1.toDoubleOrNull()
        val num2 = number2.toDoubleOrNull()

        if (num1 == null || num2 == null) return "Error"

        val result = when (operation) {
            is CalculatorOperation.Add -> num1 + num2
            is CalculatorOperation.Subtract -> num1 - num2
            is CalculatorOperation.Multiply -> num1 * num2
            is CalculatorOperation.Divide -> {
                if (num2 == 0.0) return "Error"
                num1 / num2
            }
        }

        val resultString = result.toString()

        return if (resultString.endsWith(".0")) {
            resultString.dropLast(2)
        } else {
            resultString
        }
    }
}