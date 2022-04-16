package com.example.seampaytt.core.domain.mapper

import com.example.seampaytt.core.data.local.entity.ExhibitEntity
import com.example.seampaytt.core.data.local.entity.ImagesEntity
import com.example.seampaytt.core.data.remote.response.Exhibit
import com.example.seampaytt.core.data.remote.response.ExhibitApiResponse

object ExhibitMapper {
    fun mapResponseToEntity(exhibit: List<Exhibit>): List<ExhibitEntity> {
        var exhibitItem: Exhibit? = null
        for (i in exhibit.indices) {
            exhibitItem = exhibit[i]
        }
        return listOf(
            ExhibitEntity(
            title = exhibitItem?.title.toString(),
            images = exhibitItem?.images?.map {
                ImagesEntity(images = it)
            }
        ))

    }

}