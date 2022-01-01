package com.abelsuviri.firstFeature

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.abelsuviri.firstFeature.domain.model.FirstData
import com.abelsuviri.firstFeature.domain.usecase.FirstUseCase
import com.abelsuviri.firstFeature.view.FirstFeatureViewModel
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import junit.framework.TestCase.assertEquals
import org.junit.Test
import org.junit.Before
import org.junit.Rule

class FirstFeatureViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val useCase = mockk<FirstUseCase>()
    private lateinit var subject: FirstFeatureViewModel

    @Before
    fun setup() {
        every { useCase.performAction(true) } returns FirstData("FString", "SString", 1.2)
        every { useCase.performAction(false) } returns null

        subject = FirstFeatureViewModel(useCase)
    }

    @Test
    fun `when creating ViewModel, call use case`() {
        verify(exactly = 1) { useCase.performAction(false) }
    }

    @Test
    fun `when creating ViewModel, retrieve data`() {
        assertEquals(null, subject.data.value)
    }

    @Test
    fun `when update called, call use case`() {
        // when
        subject.onUpdateData()

        // then
        verify(exactly = 1) { useCase.performAction(true) }
    }

    @Test
    fun `when update called, retrieve data`() {
        // when
        subject.onUpdateData()

        // then
        assertEquals(FirstData("FString", "SString", 1.2), subject.data.value)
    }
}
