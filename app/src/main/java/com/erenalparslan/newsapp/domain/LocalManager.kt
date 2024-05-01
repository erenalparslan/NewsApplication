package com.erenalparslan.newsapp.domain

import kotlinx.coroutines.flow.Flow

interface LocalManager {

    suspend fun saveUserEntry()

    fun readUserEntry(): Flow<Boolean>
}