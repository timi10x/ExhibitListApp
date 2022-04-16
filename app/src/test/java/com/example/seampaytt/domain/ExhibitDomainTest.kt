package com.example.seampaytt.domain

import com.example.seampaytt.core.data.remote.ExhibitRepository
import com.example.seampaytt.core.domain.usecase.ExhibitInteractor
import com.example.seampaytt.core.domain.usecase.ExhibitUsecase
import com.example.seampaytt.utils.dummyData
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock

class ExhibitDomainTest {

    private lateinit var exhibitUsecase: ExhibitUsecase
    private val exhibitRepository: ExhibitRepository = mock()

    private val exhibit = dummyData.dummyExhibit()

    @Before
    fun setup() {
        exhibitUsecase = ExhibitInteractor(exhibitRepository)
    }

    @Test
    fun `should get exhibits from repository`() {
        exhibitUsecase.getExhibits(listOf(exhibit))
        verify(exhibitRepository).getExhibits(listOf(exhibit))
        verifyNoMoreInteractions(exhibitRepository)
    }
}