package com.abelsuviri.secondFeature.domain.usecase

import com.abelsuviri.secondFeature.domain.model.SecondData
import junit.framework.TestCase.assertEquals
import org.junit.Test

class SecondUseCaseTest() {
    @Test
    fun `when use case executed, return data`() {
        val subject = SecondUseCase()
        assertEquals(SecondData("Something", 77), subject.performAction())
    }
}
