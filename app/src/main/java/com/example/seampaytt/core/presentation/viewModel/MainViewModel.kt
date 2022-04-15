package com.example.seampaytt.core.presentation.viewModel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.switchMap
import com.example.seampaytt.core.domain.model.ExhibitModel
import com.example.seampaytt.core.domain.usecase.ExhibitUsecase

class MainViewModel @ViewModelInject constructor(private val exhibitUsecase: ExhibitUsecase) :
    ViewModel() {

    private val exhibit = MutableLiveData<ExhibitModel>()

    fun setExhibit(exhibit: ExhibitModel) {
        this.exhibit.value = exhibit
    }

    fun exhibit() = exhibit.switchMap {
        exhibitUsecase.getExhibits(it).asLiveData()
    }
}