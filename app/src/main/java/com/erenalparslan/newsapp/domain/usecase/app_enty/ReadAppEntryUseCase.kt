package com.erenalparslan.newsapp.domain.usecase.app_enty

import com.erenalparslan.newsapp.domain.LocalManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntryUseCase(private val localManager: LocalManager) {

     operator fun invoke(): Flow<Boolean> {
        return localManager.readUserEntry()
    }
}