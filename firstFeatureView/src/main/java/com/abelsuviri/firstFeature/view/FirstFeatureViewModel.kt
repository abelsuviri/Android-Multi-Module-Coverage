package com.abelsuviri.firstFeature.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.abelsuviri.firstFeature.domain.model.FirstData
import com.abelsuviri.firstFeature.domain.usecase.FirstUseCase

class FirstFeatureViewModel(private val firstUseCase: FirstUseCase) : ViewModel() {
    private val _data = MutableLiveData<FirstData>()
    val data: LiveData<FirstData>
        get() = _data

    init {
        _data.value = firstUseCase.performAction(false)
    }

    fun onUpdateData() {
        _data.value = firstUseCase.performAction(true)
    }
}
