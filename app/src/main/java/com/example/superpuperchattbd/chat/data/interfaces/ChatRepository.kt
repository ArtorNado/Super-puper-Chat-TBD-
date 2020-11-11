package com.example.superpuperchattbd.chat.data.interfaces

import com.example.superpuperchattbd.common_messenger.Dialog
import io.reactivex.Single

interface ChatRepository {

    fun getDialog(id: Int): Single<Dialog>

}
