package com.example.seampaytt.core.data.remote

import com.example.seampaytt.core.data.local.LocalDataSource
import com.example.seampaytt.core.data.local.entity.ExhibitEntity
import com.example.seampaytt.core.data.remote.network.ApiResponse
import com.example.seampaytt.core.data.remote.network.NetworkBoundResource
import com.example.seampaytt.core.data.remote.network.Resource
import com.example.seampaytt.core.data.remote.response.Exhibit
import com.example.seampaytt.core.data.remote.response.ExhibitApiResponse
import com.example.seampaytt.core.domain.mapper.ExhibitMapper
import com.example.seampaytt.core.domain.model.ExhibitModel
import com.example.seampaytt.core.domain.repository.IExhibitRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ExhibitRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : IExhibitRepository {

    override fun getExhibits(exhibitModel: ExhibitModel): Flow<Resource<ExhibitEntity>> =

        object : NetworkBoundResource<ExhibitEntity, ExhibitApiResponse>() {

            override suspend fun createCall(): Flow<ApiResponse<ExhibitApiResponse>> = remoteDataSource.getExhibits(exhibitModel)

            override suspend fun saveCallResult(data: ExhibitApiResponse) {
                val exhibitData = ExhibitMapper.mapResponseToEntity(data)
                localDataSource.insertExhibit(exhibitData)
            }

            override fun loadFromDB(): Flow<ExhibitEntity> =
                localDataSource.getUpdatedExhibits()

            override fun shouldFetch(data: ExhibitEntity?): Boolean =
                data == null || exhibitModel.isSwipeRefreshed || exhibitModel.isNetworkAvailable

        }.asFlow()
}
