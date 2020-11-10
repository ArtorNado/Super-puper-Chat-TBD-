package com.example.superpuperchattbd.chat.domain

import com.example.superpuperchattbd.chat.data.interfaces.ChatRepository
import com.example.superpuperchattbd.common_chat.domain.ChatInteractor
import com.example.superpuperchattbd.common_messenger.Dialog
import io.reactivex.Single
import javax.inject.Inject

class ChatInteractorImpl @Inject constructor(
    private val repository: ChatRepository
) : ChatInteractor {

    override fun getData(id: Int): Single<Dialog> =
        repository.getDialog(id)
}