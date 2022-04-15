package com.example.seampaytt.core.di

import com.example.seampaytt.core.domain.repository.IExhibitRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [NetworkModule::class, DatabaseModule::class])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun provideRepository(exhibitRepository: IExhibitRepository): IExhibitRepository
}