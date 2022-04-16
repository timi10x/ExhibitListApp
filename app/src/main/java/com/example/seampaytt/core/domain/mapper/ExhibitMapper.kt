package com.example.seampaytt.core.domain.mapper

import com.example.seampaytt.core.data.local.entity.ExhibitEntity
import com.example.seampaytt.core.data.local.entity.ImagesEntity
import com.example.seampaytt.core.data.remote.response.Exhibit

object ExhibitMapper {
    fun mapResponseToEntity(exhibit: List<Exhibit>): List<ExhibitEntity> {
        val itemList = arrayListOf<Exhibit>()
        for (i in exhibit.indices) {
            itemList.add(exhibit[i])
        }
        val exhibits = itemList.map {
            ExhibitEntity(
                title = it.title.toString(),
                images = it.images.map { image ->
                    ImagesEntity(images = image)
                }
            )
        }
        return exhibits

    }

}