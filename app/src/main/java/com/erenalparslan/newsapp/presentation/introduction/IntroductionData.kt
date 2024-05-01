package com.erenalparslan.newsapp.presentation.introduction

import androidx.annotation.DrawableRes
import com.erenalparslan.newsapp.R

data class IntroductionData(
     var title: String,
     var description: String,
    @DrawableRes  var image: Int
)

    val pagesList= listOf(
        IntroductionData("Sayfa1","loremipsum", R.drawable.onboarding1),
        IntroductionData("Sayfa2","loremipsum", R.drawable.onboarding2),
        IntroductionData("Sayfa3","loremipsum", R.drawable.onboarding3)
    )


