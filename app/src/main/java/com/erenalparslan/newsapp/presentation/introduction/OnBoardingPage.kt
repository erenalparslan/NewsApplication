package com.erenalparslan.newsapp.presentation.introduction

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.erenalparslan.newsapp.Dimens
import com.erenalparslan.newsapp.R
import com.erenalparslan.newsapp.ui.theme.NewsAppTheme

@Composable
fun OnBoardingPage(modifier: Modifier = Modifier, page: IntroductionData) {
    Column(modifier = modifier) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.60f),
            painter = painterResource(id = page.image),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = page.title,
            modifier = Modifier.padding(horizontal = Dimens.MediumPadding2),
            fontWeight = FontWeight.SemiBold,
            style = MaterialTheme.typography.displaySmall
        )

        Text(
            text = page.description,
            modifier = Modifier.padding(horizontal = Dimens.MediumPadding2),
            fontWeight = FontWeight.SemiBold,
            style = MaterialTheme.typography.displayMedium
        )

    }
}


@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun OnBoardingPagePreview() {
    NewsAppTheme {
        OnBoardingPage(
            page = IntroductionData(
                title = "Lorem Ipsum is simply dummy",
                description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
                image = R.drawable.onboarding1
            )
        )
    }
}