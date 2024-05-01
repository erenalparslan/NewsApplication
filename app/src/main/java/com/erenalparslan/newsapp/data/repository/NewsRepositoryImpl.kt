package com.erenalparslan.newsapp.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.erenalparslan.newsapp.data.remote.NewsApi
import com.erenalparslan.newsapp.data.remote.NewsPagingSource
import com.erenalparslan.newsapp.data.remote.SearchNewsPagingSource
import com.erenalparslan.newsapp.domain.repository.NewsRepository
import com.erenalparslan.newsapp.domain.model.Article
import kotlinx.coroutines.flow.Flow

class NewsRepositoryImpl(private val newsApi: NewsApi) : NewsRepository {


    override fun getNews(sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                NewsPagingSource(
                    newsApi,
                    sources = sources.joinToString(separator = ",")
                )
            }
        ).flow
    }

    override fun searchNews(query: String, sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                SearchNewsPagingSource(
                    newsApi,
                    searchQuery = query,
                    sources = sources.joinToString(separator = ",")
                )
            }
        ).flow
    }

}