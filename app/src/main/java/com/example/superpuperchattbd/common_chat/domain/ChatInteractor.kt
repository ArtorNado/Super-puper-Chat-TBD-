package com.example.superpuperchattbd.common_chat.domain

import com.example.superpuperchattbd.common_messenger.Dialog
import com.example.superpuperchattbd.core_db.model.ProfileEntity
import io.reactivex.Single

interface ChatInteractor {

    fun getData(id: Int): Single<Dialog>

    fun sendMessage(dialog: Dialog?, message: String): Single<Dialog>

    fun getProfile(id: Int): Single<ProfileEntity>
}
