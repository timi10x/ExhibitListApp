package com.example.seampaytt.core.domain.mapper

import com.example.seampaytt.core.data.local.entity.ExhibitEntity
import com.example.seampaytt.core.data.local.entity.ImagesEntity
import com.example.seampaytt.core.data.remote.response.Exhibit
import com.example.seampaytt.core.data.remote.response.ExhibitApiResponse

object ExhibitMapper {
    fun mapResponseToEntity(exhibit: ExhibitApiResponse): ExhibitEntity {
        return ExhibitEntity(
            title = exhibit.exhibits.map {
                ExhibitEntity(title = it.title)
            }.toString(),
            images = exhibit.exhibits.map { data ->
                ImagesEntity(
                    images = data.images.toString()
                )
            }
        )
    }

}