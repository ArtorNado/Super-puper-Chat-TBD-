package com.example.superpuperchattbd.common_messenger.domain

import androidx.paging.DataSource
import com.example.superpuperchattbd.common_messenger.Dialog
import io.reactivex.Observable

interface MessengerDataSourceInteractor {

    fun getData(): DataSource.Factory<Int, Dialog>

    fun createModels(): Observable<Boolean>
}
