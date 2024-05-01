package com.loc.newsapp.presentation.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.compose.collectAsLazyPagingItems
import com.erenalparslan.newsapp.Dimens.MediumPadding1
import com.erenalparslan.newsapp.domain.model.Article
import com.erenalparslan.newsapp.presentation.common.ArticlesList
import com.erenalparslan.newsapp.presentation.common.SearchBar
import com.erenalparslan.newsapp.presentation.search.SearchState

@Composable
fun SearchScreen(
    state: SearchState,
    event:(SearchEvent) -> Unit,
    navigateToDetails:(Article) -> Unit
) {

    Column(
        modifier = Modifier
            .padding(top = MediumPadding1, start = MediumPadding1, end = MediumPadding1)
            .fillMaxSize()
            .statusBarsPadding(),
        verticalArrangement = Arrangement.Top
    ) {
        SearchBar(
            text = state.searchQuery,
            readOnly = false,
            onValueChange = { event(SearchEvent.UpdateSearchQuery(it)) },
            onSearch = {
                event(SearchEvent.SearchNews)
            }
        )
        Spacer(modifier = Modifier.height(MediumPadding1))
        state.articles?.let {
            val articles = it.collectAsLazyPagingItems()
            ArticlesList(
                articles = articles,
                onClick = navigateToDetails
            )
        }
    }
}