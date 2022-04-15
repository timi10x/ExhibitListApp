package com.example.seampaytt.core.data.remote.network

import com.example.seampaytt.core.data.remote.response.ExhibitApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ExhibitsLoaderService {

    @GET("/list")
    suspend fun getExhibitList() : ExhibitApiResponse

}