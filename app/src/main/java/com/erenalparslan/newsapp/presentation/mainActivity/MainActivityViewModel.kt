package com.erenalparslan.newsapp.presentation.mainActivity

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.erenalparslan.newsapp.domain.usecase.app_enty.AppEntryUseCases
import com.loc.newsapp.presentation.navgraph.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(val appEntryUseCases: AppEntryUseCases):ViewModel() {

     var splashScreenCondition by mutableStateOf(false)
        private set

     var startDestination by mutableStateOf(Route.AppStartNavigation.route)
        private set

    init {
        appEntryUseCases.readAppEntryUseCase().onEach { shouldStartFromHomeScreen ->
            if (shouldStartFromHomeScreen) {
                startDestination = Route.NewsNavigation.route
            } else {
                startDestination = Route.AppStartNavigation.route
            }
            delay(3000)
            splashScreenCondition=false
        }.launchIn(viewModelScope)
    }

}