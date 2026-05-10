package com.firhan.calculator.core.di
import com.firhan.calculator.feature.calculator.domain.usecase.CalculateResultUseCase

class AppContainer {
    val calculateResultUseCase: CalculateResultUseCase by lazy {
        CalculateResultUseCase()
    }
}