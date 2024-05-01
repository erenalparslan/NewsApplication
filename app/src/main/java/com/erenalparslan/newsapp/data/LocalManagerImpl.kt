package com.erenalparslan.newsapp.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.erenalparslan.newsapp.domain.LocalManager
import com.erenalparslan.newsapp.util.Constans
import com.erenalparslan.newsapp.util.Constans.USER_SETTINGS
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class LocalManagerImpl(private val context: Context) : LocalManager {

    override suspend fun saveUserEntry() {
        context.dataStore.edit { settings ->
            settings[PreferencesKey.APP_ENTRY] = true
        }
    }

    override fun readUserEntry(): Flow<Boolean> {
        return context.dataStore.data.map { preferences ->
            preferences[PreferencesKey.APP_ENTRY] ?: false
        }
    }

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = USER_SETTINGS)

    private object PreferencesKey {
        val APP_ENTRY = booleanPreferencesKey(name = Constans.APP_ENTRY)
    }

}
