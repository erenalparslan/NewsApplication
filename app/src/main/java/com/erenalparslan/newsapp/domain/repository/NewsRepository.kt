package com.erenalparslan.newsapp.domain.repository

import androidx.paging.PagingData
import com.erenalparslan.newsapp.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

     fun getNews(sources: List<String>): Flow<PagingData<Article>>

     fun searchNews(query :String,sources: List<String> ) :Flow<PagingData<Article>>
}