package com.example.seampaytt.core.data.local

import androidx.room.TypeConverter
import com.example.seampaytt.core.data.local.entity.ImagesEntity
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

object RoomConverter {

    private val moshi = Moshi
        .Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val type = Types.newParameterizedType(List::class.java, ImagesEntity::class.java)
    private val adapter = moshi.adapter<List<ImagesEntity>>(type)

    @TypeConverter
    @JvmStatic
    fun fromStringToImages(value: String): List<ImagesEntity> =
        value.let { adapter.fromJson(it).orEmpty() }

    @TypeConverter
    @JvmStatic
    fun fromImagesToString(images: List<ImagesEntity>): String = adapter.toJson(images)
}