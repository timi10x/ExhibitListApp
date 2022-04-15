package com.example.seampaytt.core.di

import android.content.Context
import androidx.room.Room
import com.example.seampaytt.core.data.local.room.ExhibitDao
import com.example.seampaytt.core.data.local.room.ExhibitDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): ExhibitDatabase =
        Room.databaseBuilder(
            context,
            ExhibitDatabase::class.java, "Exhibit.db"
        )
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    fun provideExhibitDao(database: ExhibitDatabase): ExhibitDao = database.exhibitDao()
}

