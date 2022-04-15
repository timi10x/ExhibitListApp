package com.example.seampaytt.core.data.remote.response

import com.squareup.moshi.Json

data class Exhibit(
    @field:Json(name = "title") var title: String? = null,
    @field:Json(name = "images") var images: ArrayList<String> = arrayListOf()
)

data class ExhibitApiResponse(
    val exhibits: List<Exhibit>
)