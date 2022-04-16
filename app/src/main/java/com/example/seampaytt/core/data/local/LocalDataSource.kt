package com.example.seampaytt.core.data.local

import com.example.seampaytt.core.data.local.entity.ExhibitEntity
import com.example.seampaytt.core.data.local.room.ExhibitDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val exhibitDao: ExhibitDao) {

    fun getUpdatedExhibits(): Flow<List<ExhibitEntity>> = exhibitDao.getUpdatedExhibit()

    suspend fun insertExhibit(exhibit: List<ExhibitEntity>) = exhibitDao.insertExhibit(exhibit)

}
