package com.erenalparslan.newsapp.presentation.bookmark

import com.erenalparslan.newsapp.domain.model.Article

data class BookmarkState(
    val articles: List<Article> = emptyList()
)