package com.example.seampaytt.presentation

import com.example.seampaytt.core.data.local.entity.ExhibitEntity
import com.example.seampaytt.core.data.remote.network.Resource
import com.example.seampaytt.core.domain.usecase.ExhibitUsecase
import com.example.seampaytt.core.presentation.viewModel.MainViewModel
import com.example.seampaytt.utils.dummyData
import com.example.seampaytt.utils.getValueForTest
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class ExhibitViewModelTest {

    private lateinit var exhibitViewModel: MainViewModel
    private val exhibitUsecase: ExhibitUsecase = mock()

    private val exhibits = mock<List<ExhibitEntity>>()
    private val result = Resource.Success(exhibits)

    private val exhibit = listOf(dummyData.dummyExhibit())

    @Before
    fun setup(){
        exhibitViewModel = MainViewModel(exhibitUsecase)
        exhibitViewModel.setExhibit(exhibit)
    }

    @Test
    fun `get exhibit from usecase successfully`() {
        mockSuccessfulCase()
        exhibitViewModel.exhibit().getValueForTest()
        verify(exhibitUsecase, times(1)).getExhibits(exhibit)
    }

    @Test
    fun `get exhibits successfully`() {
        mockSuccessfulCase()
        assertEquals(result, exhibitViewModel.exhibit().getValueForTest())
    }

    private fun mockSuccessfulCase() {
        runBlocking {
            whenever(exhibitUsecase.getExhibits(exhibit)).thenReturn(
                flow {
                    emit(result)
                }
            )
        }
    }
}