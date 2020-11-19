package com.example.superpuperchattbd.chat.data.interfaces

import com.example.superpuperchattbd.common_messenger.Dialog
import com.example.superpuperchattbd.core_db.model.DialogEntity
import io.reactivex.Single

interface ChatRepository {

    fun getDialog(id: Int): Single<Dialog>

    fun sendMessage(dialog: DialogEntity): Single<Dialog>

}
