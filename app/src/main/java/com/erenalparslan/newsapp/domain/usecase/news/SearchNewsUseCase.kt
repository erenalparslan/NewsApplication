package com.erenalparslan.newsapp.domain.usecase.news

import androidx.paging.PagingData
import com.erenalparslan.newsapp.domain.model.Article
import com.erenalparslan.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class SearchNewsUseCase(
    private val newsRepository: NewsRepository
) {
    operator fun invoke(searchQuery: String, sources: List<String>): Flow<PagingData<Article>> {
        return newsRepository.searchNews(
            query = searchQuery,
            sources = sources
        )
    }
}