package com.example.seampaytt.core.domain.repository

import com.example.seampaytt.core.data.local.entity.ExhibitEntity
import com.example.seampaytt.core.data.remote.network.Resource
import com.example.seampaytt.core.domain.model.ExhibitModel
import kotlinx.coroutines.flow.Flow

interface IExhibitRepository {

    fun getExhibits(exhibitModel: List<ExhibitModel>): Flow<Resource<List<ExhibitEntity>>>

}