package com.example.superpuperchattbd.messenger.domain

import android.util.Log
import androidx.paging.DataSource
import com.example.superpuperchattbd.core_db.AppDatabase
import com.example.superpuperchattbd.core_db.model.DialogEntity
import io.reactivex.Completable
import javax.inject.Inject

class MessengerInteractor @Inject constructor(
    private val db: AppDatabase
) : MessengerDataSourceInteractor {

    override fun getData(): DataSource.Factory<Int, DialogEntity> {
        Log.e("GET", "GET_--_")
        return db.dialogDao().getDialogs()
    }

    override fun setData(): Completable {
        return db.dialogDao().setDialog(DialogEntity(7, "Piter", "Hello", "17:37", "http/", 1))
    }
}