package com.erenalparslan.newsapp.presentation.introduction

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.erenalparslan.newsapp.domain.usecase.app_enty.AppEntryUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class IntroductionViewModel @Inject constructor(private val appEntryUseCases: AppEntryUseCases) : ViewModel() {


    fun onEvent(onBoardingEvent: OnBoardingEvent){
        when(onBoardingEvent){
            OnBoardingEvent.SaveAppEntry -> saveAppEntry()
        }
    }


    private fun saveAppEntry(){
        viewModelScope.launch {
            appEntryUseCases.saveAppEntryUseCase.invoke()
        }
    }
}