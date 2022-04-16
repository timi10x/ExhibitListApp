package com.example.seampaytt.core.domain.mapper

import com.example.seampaytt.core.data.local.entity.ExhibitEntity
import com.example.seampaytt.core.data.local.entity.ImagesEntity
import com.example.seampaytt.core.data.remote.response.Exhibit
import com.example.seampaytt.core.data.remote.response.ExhibitApiResponse

object ExhibitMapper {
    fun mapResponseToEntity(exhibit: Exhibit): ExhibitEntity {
        return ExhibitEntity(
            title = exhibit.title.toString(),
            images = exhibit.images.map {
                ImagesEntity(images = it)
            }
        )
    }

}