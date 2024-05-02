package com.erenalparslan.newsapp.data.remote.dto

import com.erenalparslan.newsapp.domain.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)