package com.erenalparslan.newsapp.domain.usecases.app_entry

import com.erenalparslan.newsapp.domain.manger.LocalUserManger
import javax.inject.Inject

class SaveAppEntry @Inject constructor(
    private val localUserManger: LocalUserManger
) {

    suspend operator fun invoke(){
        localUserManger.saveAppEntry()
    }

}