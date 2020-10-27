package com.example.superpuperchattbd.messenger.data.mappers

import com.example.superpuperchattbd.common_messenger.Dialog
import com.example.superpuperchattbd.core_db.model.DialogEntity

fun mapDialogEntityToLocal(dialogEntity: DialogEntity): Dialog {
    return with(dialogEntity){
        Dialog(
            id,
            interlocutorName,
            lastMessage,
            lastMessageTime,
            imageUrl,
            lastMessageStatus
        )
    }
}
