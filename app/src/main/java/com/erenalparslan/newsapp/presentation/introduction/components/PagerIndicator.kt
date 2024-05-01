package com.erenalparslan.newsapp.presentation.introduction.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.erenalparslan.newsapp.Dimens.IndicatorSize
import com.erenalparslan.newsapp.R
import com.erenalparslan.newsapp.presentation.introduction.IntroductionData
import com.erenalparslan.newsapp.presentation.introduction.OnBoardingPage
import com.erenalparslan.newsapp.presentation.introduction.PagerState
import com.erenalparslan.newsapp.ui.theme.BlueGray
import com.erenalparslan.newsapp.ui.theme.NewsAppTheme

@Composable
fun PagerIndicator(
    modifier: Modifier = Modifier,
    pagesSize: Int,
    selectedPage: Int,
    selectedColor: Color = MaterialTheme.colorScheme.primary,
    unselectedColor: Color = BlueGray,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        repeat(pagesSize) { page ->
            Box(
                Modifier
                    .size(IndicatorSize)
                    .clip(CircleShape)
                    .background(if (selectedPage == page) selectedColor else unselectedColor)
            )
        }

    }

}

@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PageIndicatorPreview() {
    NewsAppTheme {
        PagerIndicator(
            pagesSize = 3,
            selectedPage = 2,
        )
    }
}