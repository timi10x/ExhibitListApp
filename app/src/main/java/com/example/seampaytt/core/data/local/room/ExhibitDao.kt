package com.example.seampaytt.core.data.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.seampaytt.core.data.local.entity.ExhibitEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ExhibitDao {

    @Query("SELECT * FROM exhibit")
    fun getUpdatedExhibit(): Flow<List<ExhibitEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertExhibit(exhibit: List<ExhibitEntity>)
}
