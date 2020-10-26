package com.example.superpuperchattbd.common_messenger.domain

import androidx.paging.DataSource
import com.example.superpuperchattbd.core_db.model.DialogEntity
import io.reactivex.Completable

interface MessengerDataSourceInteractor {

    fun getData(): DataSource.Factory<Int, DialogEntity>

    fun setData(): Completable
}
