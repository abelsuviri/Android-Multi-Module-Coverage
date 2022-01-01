package com.abelsuviri.firstFeature.domain.usecase

import com.abelsuviri.firstFeature.domain.model.FirstData

class FirstUseCase {
    fun performAction(param: Boolean) = if (param)
        FirstData("First String", "Second String", 0.0)
    else
        null
}
