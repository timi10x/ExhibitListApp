package com.example.seampaytt.utils

import com.example.seampaytt.core.domain.model.ExhibitModel

object dummyData {

    fun dummyExhibit() = ExhibitModel(
        isSwipeRefreshed = true,
        isNetworkAvailable = true
    )
}