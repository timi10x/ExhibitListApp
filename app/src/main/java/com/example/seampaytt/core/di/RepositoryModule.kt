package com.example.seampaytt.core.di

import com.example.seampaytt.core.domain.repository.IExhibitRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module(includes = [NetworkModule::class, DatabaseModule::class])
@InstallIn(ApplicationComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(exhibitRepository: IExhibitRepository): IExhibitRepository
}