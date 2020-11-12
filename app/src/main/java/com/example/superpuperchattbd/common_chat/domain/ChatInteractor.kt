package com.example.superpuperchattbd.common_chat.domain

import com.example.superpuperchattbd.common_messenger.Dialog
import io.reactivex.Single

interface ChatInteractor {

    fun getData(id: Int): Single<Dialog>
}
