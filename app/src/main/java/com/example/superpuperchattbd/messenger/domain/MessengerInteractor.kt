package com.example.superpuperchattbd.messenger.domain

import androidx.paging.DataSource
import com.example.superpuperchattbd.common_messenger.Dialog
import com.example.superpuperchattbd.common_messenger.domain.MessengerDataSourceInteractor
import com.example.superpuperchattbd.messenger.data.interfaces.MessengerRepository
import io.reactivex.Observable
import javax.inject.Inject

class MessengerInteractor @Inject constructor(
    private val messengerRepository: MessengerRepository
) : MessengerDataSourceInteractor {

    override fun getData(): DataSource.Factory<Int, Dialog> {
        return messengerRepository.getData()
    }

    override fun createModels(): Observable<Boolean> {
        return messengerRepository.createModels()
    }
}
