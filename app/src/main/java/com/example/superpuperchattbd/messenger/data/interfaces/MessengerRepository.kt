package com.example.superpuperchattbd.messenger.data.interfaces

import androidx.paging.DataSource
import com.example.superpuperchattbd.common_messenger.Dialog
import io.reactivex.Observable

interface MessengerRepository {

    fun getData(): DataSource.Factory<Int, Dialog>

    fun createModels(): Observable<Boolean>
}
