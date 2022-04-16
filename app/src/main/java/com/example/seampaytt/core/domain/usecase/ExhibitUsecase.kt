package com.example.seampaytt.core.domain.usecase

import com.example.seampaytt.core.data.local.entity.ExhibitEntity
import com.example.seampaytt.core.data.remote.network.Resource
import com.example.seampaytt.core.domain.model.ExhibitModel
import kotlinx.coroutines.flow.Flow

interface ExhibitUsecase {

    fun getExhibits(exhibitModel: List<ExhibitModel>): Flow<Resource<List<ExhibitEntity>>>
}