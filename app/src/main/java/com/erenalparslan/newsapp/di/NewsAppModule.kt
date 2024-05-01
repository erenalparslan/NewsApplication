package com.erenalparslan.newsapp.di

import android.app.Application
import com.erenalparslan.newsapp.data.LocalManagerImpl
import com.erenalparslan.newsapp.domain.LocalManager
import com.erenalparslan.newsapp.domain.usecase.app_enty.AppEntryUseCases
import com.erenalparslan.newsapp.domain.usecase.app_enty.ReadAppEntryUseCase
import com.erenalparslan.newsapp.domain.usecase.app_enty.SaveAppEntryUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NewsAppModule {

    @Provides
    @Singleton
    fun provideLocalManager(
        application: Application
    ): LocalManager = LocalManagerImpl(application)

    @Provides
    @Singleton
    fun provideEntryUseCase(localManager: LocalManager): AppEntryUseCases {
        return AppEntryUseCases(
            ReadAppEntryUseCase(localManager = localManager),
            SaveAppEntryUseCase(localManager = localManager)
        )

    }


}