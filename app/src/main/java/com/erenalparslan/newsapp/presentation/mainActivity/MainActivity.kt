package com.erenalparslan.newsapp.presentation.mainActivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import com.erenalparslan.newsapp.presentation.nvgraph.NavGraph
import com.erenalparslan.newsapp.ui.theme.NewsAppTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewmodel by viewModels<MainActivityViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window,false)
        installSplashScreen().apply {
            setKeepOnScreenCondition(condition = { viewmodel.splashScreenCondition })
        }
        setContent {
            NewsAppTheme {

                var isDarkTheme= isSystemInDarkTheme()
                var systemUiController= rememberSystemUiController()

                SideEffect{
                    systemUiController.setSystemBarsColor(
                        color = Color.Transparent,
                        darkIcons = !isDarkTheme
                    )
                }

                // A surface container using the 'background' color from the theme

                    Box(modifier = Modifier
                        .background(MaterialTheme.colorScheme.background)
                        .fillMaxSize()){
                        NavGraph(startDestination = viewmodel.startDestination)
                    }
            }
        }
    }
}

