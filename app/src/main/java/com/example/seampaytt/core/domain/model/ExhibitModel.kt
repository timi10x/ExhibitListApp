package com.example.seampaytt.core.domain.model

import com.squareup.moshi.Json

data class ExhibitModel(
    var title: String? = null,
    var images: ArrayList<String> = arrayListOf(),
    val isSwipeRefreshed: Boolean,
    val isNetworkAvailable: Boolean
)