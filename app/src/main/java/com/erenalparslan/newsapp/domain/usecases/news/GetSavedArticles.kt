package com.erenalparslan.newsapp.domain.usecases.news

import com.erenalparslan.newsapp.data.local.NewsDao
import com.erenalparslan.newsapp.domain.model.Article
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSavedArticles @Inject constructor(
    private val newsDao: NewsDao
) {

    operator fun invoke(): Flow<List<Article>>{
        return newsDao.getArticles()
    }

}