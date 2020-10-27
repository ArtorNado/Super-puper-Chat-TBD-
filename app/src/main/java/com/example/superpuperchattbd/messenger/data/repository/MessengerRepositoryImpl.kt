package com.example.superpuperchattbd.messenger.data.repository

import androidx.paging.DataSource
import com.example.superpuperchattbd.common_messenger.Dialog
import com.example.superpuperchattbd.core_db.AppDatabase
import com.example.superpuperchattbd.messenger.data.interfaces.MessengerRepository
import com.example.superpuperchattbd.messenger.data.mappers.mapDialogEntityToLocal
import javax.inject.Inject

class MessengerRepositoryImpl @Inject constructor(
    private val db: AppDatabase
) : MessengerRepository {

    override fun getData(): DataSource.Factory<Int, Dialog> {
        return db.dialogDao().getDialogs()
            .map { mapDialogEntityToLocal(it) }
    }
}
