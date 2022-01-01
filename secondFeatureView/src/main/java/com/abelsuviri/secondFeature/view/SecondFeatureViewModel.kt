package com.abelsuviri.secondFeature.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.abelsuviri.secondFeature.domain.model.SecondData
import com.abelsuviri.secondFeature.domain.usecase.SecondUseCase

class SecondFeatureViewModel(
    private val secondUseCase: SecondUseCase
) : ViewModel() {
    private val _secondData = MutableLiveData<SecondData>()
    val secondData: LiveData<SecondData>
        get() = _secondData

    fun onRetrieveData() {
        _secondData.value = secondUseCase.performAction()
    }
}
