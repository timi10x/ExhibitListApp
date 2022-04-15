package com.example.seampaytt.core.di

import com.example.seampaytt.core.domain.usecase.ExhibitInteractor
import com.example.seampaytt.core.domain.usecase.ExhibitUsecase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {
    @Binds
    abstract fun provideWeatherUseCase(exhibitInteractor: ExhibitInteractor): ExhibitUsecase
}
