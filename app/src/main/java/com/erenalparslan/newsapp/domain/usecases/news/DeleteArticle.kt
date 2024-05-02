package com.erenalparslan.newsapp.domain.usecases.news

import com.erenalparslan.newsapp.data.local.NewsDao
import com.erenalparslan.newsapp.domain.model.Article
import javax.inject.Inject

class DeleteArticle @Inject constructor(
    private val newsDao: NewsDao
) {

    suspend operator fun invoke(article: Article){
        newsDao.delete(article = article)
    }

}