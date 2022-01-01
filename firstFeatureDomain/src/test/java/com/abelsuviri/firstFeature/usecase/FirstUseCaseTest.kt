package com.abelsuviri.firstFeature.usecase

import com.abelsuviri.firstFeature.domain.model.FirstData
import com.abelsuviri.firstFeature.domain.usecase.FirstUseCase
import junit.framework.TestCase.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class FirstUseCaseTest(private val param: Boolean, private val result: FirstData?) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data() = listOf(
            arrayOf(true, FirstData("First String", "Second String", 0.0)),
            arrayOf(false, null)
        )
    }

    @Test
    fun `when use case executed, return data`() {
        // given
        val subject = FirstUseCase()

        // then
        assertEquals(result, subject.performAction(param))
    }
}
