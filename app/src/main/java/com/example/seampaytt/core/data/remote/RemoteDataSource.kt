package com.example.seampaytt.core.data.remote

import com.example.seampaytt.core.data.remote.network.ApiResponse
import com.example.seampaytt.core.data.remote.network.ExhibitsLoaderService
import com.example.seampaytt.core.data.remote.response.Exhibit
import com.example.seampaytt.core.data.remote.response.ExhibitApiResponse
import com.example.seampaytt.core.domain.model.ExhibitModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val exhibitsLoaderService: ExhibitsLoaderService) {

    suspend fun getExhibits(exhibit: ExhibitModel) : Flow<ApiResponse<List<Exhibit>>> = flow {
        try {
            val response = exhibitsLoaderService.getExhibitList()
            emit(ApiResponse.Success(response))
        } catch (e: Exception) {
            emit(ApiResponse.Error(e.toString()))
            Timber.e(e.toString())
        }
    }.flowOn(Dispatchers.IO)
}