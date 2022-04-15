package com.example.seampaytt.core.data.local.room

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.seampaytt.core.data.local.entity.ExhibitEntity
import kotlinx.coroutines.flow.Flow

interface ExhibitDao {

    @Query("SELECT * FROM exhibit")
    fun getUpdatedExhibit(): Flow<ExhibitEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWeather(exhibit: ExhibitEntity)
}
