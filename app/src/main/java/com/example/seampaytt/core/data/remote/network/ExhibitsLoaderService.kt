package com.example.seampaytt.core.data.remote.network

import retrofit2.http.GET
import retrofit2.http.Query

interface ExhibitsLoaderService {

    @GET("list")
    suspend fun getExhibitList() : Unit

}