package com.example.seampaytt.core.domain.mapper

import android.util.Log
import com.example.seampaytt.core.data.local.entity.ExhibitEntity
import com.example.seampaytt.core.data.local.entity.ImagesEntity
import com.example.seampaytt.core.data.remote.response.Exhibit
import com.example.seampaytt.core.data.remote.response.ExhibitApiResponse

object ExhibitMapper {
    fun mapResponseToEntity(exhibit: List<Exhibit>): List<ExhibitEntity> {
        val itemList = arrayListOf<Exhibit>()
        for (i in exhibit.indices) {
            itemList.add(exhibit[i])
        }
        val singleExhibit = itemList.map {
            ExhibitEntity(
                title = it.title.toString(),
                images = it.images.map { image ->
                    ImagesEntity(images = image)
                }
            )
        }
        Log.d("bigW single exh", "${singleExhibit}")
        Log.d("bigW itemlist", "${itemList}")
        return singleExhibit

    }

}