package com.example.seampaytt.core.domain.model

import com.squareup.moshi.Json

data class ExhibitModel(
    val isSwipeRefreshed: Boolean,
    val isNetworkAvailable: Boolean
)