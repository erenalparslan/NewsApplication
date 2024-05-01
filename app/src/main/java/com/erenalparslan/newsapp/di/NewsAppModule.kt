package com.erenalparslan.newsapp.di

import android.app.Application
import com.erenalparslan.newsapp.data.LocalManagerImpl
import com.erenalparslan.newsapp.data.remote.NewsApi
import com.erenalparslan.newsapp.data.repository.NewsRepositoryImpl
import com.erenalparslan.newsapp.domain.LocalManager
import com.erenalparslan.newsapp.domain.repository.NewsRepository
import com.erenalparslan.newsapp.domain.usecase.app_enty.AppEntryUseCases
import com.erenalparslan.newsapp.domain.usecase.app_enty.ReadAppEntryUseCase
import com.erenalparslan.newsapp.domain.usecase.app_enty.SaveAppEntryUseCase
import com.erenalparslan.newsapp.domain.usecase.news.GetNewsUseCase
import com.erenalparslan.newsapp.domain.usecase.news.NewsUseCases
import com.erenalparslan.newsapp.util.Constans.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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


    @Provides
    @Singleton
    fun provideApiInstance(): NewsApi {
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi,
    ): NewsRepository {
        return NewsRepositoryImpl(newsApi)
    }

    @Provides
    @Singleton
    fun provideNewsUseCases(
        newsRepository: NewsRepository
    ): NewsUseCases {
        return NewsUseCases(
            getNews = GetNewsUseCase(newsRepository),
        )
    }


}