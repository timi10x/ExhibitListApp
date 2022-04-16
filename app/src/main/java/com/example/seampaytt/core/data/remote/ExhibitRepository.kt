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

    override fun getExhibits(exhibitModel: List<ExhibitModel>): Flow<Resource<List<ExhibitEntity>>> =

        object : NetworkBoundResource<List<ExhibitEntity>, List<Exhibit>>() {
            override fun loadFromDB(): Flow<List<ExhibitEntity>> =
                localDataSource.getUpdatedExhibits()

            override fun shouldFetch(data: List<ExhibitEntity>?): Boolean {
                var exhibits= ExhibitModel(isSwipeRefreshed = true, isNetworkAvailable = true)
                for (i in exhibitModel.indices) {
                    exhibits = exhibitModel[i]
                }
                return data == null || exhibits.isSwipeRefreshed || exhibits.isNetworkAvailable
            }


            override suspend fun createCall(): Flow<ApiResponse<List<Exhibit>>> =
                remoteDataSource.getExhibits(exhibitModel)

            override suspend fun saveCallResult(data: List<Exhibit>) {
                val exhibitData = ExhibitMapper.mapResponseToEntity(data)
                localDataSource.insertExhibit(exhibitData)
            }

        }.asFlow()
}
