package com.example.superpuperchattbd.messenger.data.mappers

import com.example.superpuperchattbd.common_messenger.Dialog
import com.example.superpuperchattbd.core_db.model.DialogEntity

fun mapDialogEntityToLocal(dialogEntity: DialogEntity): Dialog {
    return with(dialogEntity){
        Dialog(
            id,
            senderId,
            imageUrl,
            messages
        )
    }
}

fun mapLocalToDialogEntity(dialog: Dialog): DialogEntity {
    return with(dialog){
        DialogEntity(
            id,
            senderId,
            imageUrl,
            messages
        )
    }
}
