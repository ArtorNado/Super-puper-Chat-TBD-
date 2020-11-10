package com.example.superpuperchattbd.chat.data.repository

import com.example.superpuperchattbd.chat.data.interfaces.ChatRepository
import com.example.superpuperchattbd.common_messenger.Dialog
import com.example.superpuperchattbd.core_db.AppDatabase
import com.example.superpuperchattbd.messenger.data.mappers.mapDialogEntityToLocal
import io.reactivex.Single
import javax.inject.Inject

class ChatRepositoryImpl @Inject constructor(
    private val db: AppDatabase
) : ChatRepository {

    override fun getDialog(id: Int): Single<Dialog> {
        return db.dialogDao().getDialogById(id).map {
            mapDialogEntityToLocal(it)
        }
    }

}