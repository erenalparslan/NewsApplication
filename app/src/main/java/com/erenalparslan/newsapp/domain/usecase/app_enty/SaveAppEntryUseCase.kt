package com.erenalparslan.newsapp.domain.usecase.app_enty

import com.erenalparslan.newsapp.domain.LocalManager

class SaveAppEntryUseCase(private val localManager: LocalManager) {

    suspend operator fun invoke(){
        localManager.saveUserEntry()
    }
}