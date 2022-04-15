package com.example.seampaytt.core.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.seampaytt.core.data.local.RoomConverter
import com.example.seampaytt.core.data.local.entity.ExhibitEntity

@Database(
    entities = [ExhibitEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(RoomConverter::class)
abstract class ExhibitDatabase : RoomDatabase() {
    abstract fun exhibitDao(): ExhibitDao
}
