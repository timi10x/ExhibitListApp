package com.example.seampaytt.core.domain.usecase

import com.example.seampaytt.core.data.local.entity.ExhibitEntity
import com.example.seampaytt.core.data.remote.network.Resource
import com.example.seampaytt.core.domain.model.ExhibitModel
import com.example.seampaytt.core.domain.repository.IExhibitRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ExhibitInteractor @Inject constructor(private val repository: IExhibitRepository):
    ExhibitUsecase {

    override fun getExhibits(exhibitModel: ExhibitModel): Flow<Resource<ExhibitEntity>> =
        repository.getExhibits(exhibitModel)

}