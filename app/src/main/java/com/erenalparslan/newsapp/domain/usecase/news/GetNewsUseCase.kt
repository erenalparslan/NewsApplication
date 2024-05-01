package com.erenalparslan.newsapp.domain.usecase.news

import androidx.paging.PagingData
import com.erenalparslan.newsapp.domain.repository.NewsRepository
import com.erenalparslan.newsapp.domain.model.Article
import kotlinx.coroutines.flow.Flow

class GetNewsUseCase(private val newsRepository: NewsRepository) {

    operator fun invoke(source: List<String>): Flow<PagingData<Article>> {
        return newsRepository.getNews(source)
    }
}