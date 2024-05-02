package com.erenalparslan.newsapp.di

import android.app.Application
import androidx.room.Room
import com.erenalparslan.newsapp.data.local.NewsDao
import com.erenalparslan.newsapp.data.local.NewsDatabase
import com.erenalparslan.newsapp.data.local.NewsTypeConvertor
import com.erenalparslan.newsapp.data.manger.LocalUserMangerImpl
import com.erenalparslan.newsapp.data.remote.NewsApi
import com.erenalparslan.newsapp.domain.manger.LocalUserManger
import com.erenalparslan.newsapp.domain.usecases.app_entry.ReadAppEntry
import com.erenalparslan.newsapp.domain.usecases.app_entry.SaveAppEntry
import com.erenalparslan.newsapp.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


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
    fun provideNewsDatabase(
        application: Application
    ): NewsDatabase {
        return Room.databaseBuilder(
            context = application,
            klass = NewsDatabase::class.java,
            name = "news_db"
        ).addTypeConverter(NewsTypeConvertor())
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideNewsDao(
        newsDatabase: NewsDatabase
    ): NewsDao = newsDatabase.newsDao

}