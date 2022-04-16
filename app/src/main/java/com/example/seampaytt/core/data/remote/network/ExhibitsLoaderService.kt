package com.example.seampaytt.core.data.remote.network

import com.example.seampaytt.core.data.remote.response.Exhibit
import retrofit2.http.GET

interface ExhibitsLoaderService {

    @GET("list")
    suspend fun getExhibitList() : List<Exhibit>

}