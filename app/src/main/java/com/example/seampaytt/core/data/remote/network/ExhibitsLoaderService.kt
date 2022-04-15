package com.example.seampaytt.core.data.remote.network

import com.example.seampaytt.core.data.remote.response.Exhibit
import retrofit2.http.GET
import retrofit2.http.Query

interface ExhibitsLoaderService {

    @GET("list")
    suspend fun getExhibitList() : List<Exhibit>

}