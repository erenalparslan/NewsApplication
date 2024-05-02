package com.erenalparslan.newsapp.domain.usecases.news

import androidx.paging.PagingData
import com.erenalparslan.newsapp.domain.model.Article
import com.erenalparslan.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetNews @Inject constructor(
    private val newsRepository: NewsRepository
) {
    operator fun invoke(sources: List<String>): Flow<PagingData<Article>> {
        return newsRepository.getNews(sources = sources)
    }
}