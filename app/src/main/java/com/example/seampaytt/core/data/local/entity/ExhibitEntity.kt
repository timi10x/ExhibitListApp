package com.example.seampaytt.core.data.local.entity

import androidx.annotation.NonNull
import androidx.room.*
import com.example.seampaytt.core.data.local.RoomConverter

@Entity(tableName = "exhibit")
data class ExhibitEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id") var id: Int? = 0,
    @ColumnInfo(name = "title") var title: String? = "",
    @TypeConverters(RoomConverter::class) var images: List<ImagesEntity>? = null,
)

data class ImagesEntity(
    @ColumnInfo(name = "images") var images: String? = ""
)
