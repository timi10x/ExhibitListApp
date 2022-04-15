package com.example.seampaytt.core.di

import com.example.seampaytt.core.domain.usecase.ExhibitInteractor
import com.example.seampaytt.core.domain.usecase.ExhibitUsecase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
abstract class AppModule {
    @Binds
    abstract fun provideExhibitUseCase(exhibitInteractor: ExhibitInteractor): ExhibitUsecase

}
