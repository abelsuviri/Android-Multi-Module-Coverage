package com.abelsuviri.secondFeature

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.abelsuviri.secondFeature.domain.model.SecondData
import com.abelsuviri.secondFeature.domain.usecase.SecondUseCase
import com.abelsuviri.secondFeature.view.SecondFeatureViewModel
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import junit.framework.TestCase.assertEquals
import org.junit.Test
import org.junit.Before
import org.junit.Rule

class SecondFeatureViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val useCase = mockk<SecondUseCase>()
    private val subject = SecondFeatureViewModel(useCase)

    @Before
    fun setup() {
        every { useCase.performAction() } returns SecondData("String", 0)
    }

    @Test
    fun `when should retrieve data, call use case `() {
        // when
        subject.onRetrieveData()

        verify(exactly = 1) { useCase.performAction() }
    }

    @Test
    fun `when should retrieve data, update values`() {
        // when
        subject.onRetrieveData()

        // then
        assertEquals(SecondData("String", 0), subject.secondData.value)
    }
}
