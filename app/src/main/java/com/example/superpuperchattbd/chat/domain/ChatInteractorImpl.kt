package com.example.superpuperchattbd.chat.domain

import com.example.superpuperchattbd.chat.data.interfaces.ChatRepository
import com.example.superpuperchattbd.common_chat.domain.ChatInteractor
import com.example.superpuperchattbd.common_messenger.Dialog
import com.example.superpuperchattbd.common_messenger.Message
import com.example.superpuperchattbd.messenger.data.mappers.mapLocalToDialogEntity
import io.reactivex.Single
import java.lang.IllegalStateException
import java.util.*
import javax.inject.Inject

class ChatInteractorImpl @Inject constructor(
    private val repository: ChatRepository
) : ChatInteractor {

    override fun getData(id: Int): Single<Dialog> =
        repository.getDialog(id)

    override fun sendMessage(dialog: Dialog?, message: String): Single<Dialog> {
        return dialog?.run {
            val newListMessage = mutableListOf<Message>().apply {
                addAll(messages)
                add(Message(0, message, Date(), 1))
            }
            repository.sendMessage(
                mapLocalToDialogEntity(dialog.copy(messages = newListMessage))
            )
        } ?: Single.error(IllegalStateException("Dialog is null"))
    }

}
