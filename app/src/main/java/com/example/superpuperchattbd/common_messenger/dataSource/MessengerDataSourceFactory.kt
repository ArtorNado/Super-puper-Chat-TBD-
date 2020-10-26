package com.example.superpuperchattbd.common_messenger.dataSource

import androidx.paging.DataSource
import com.example.superpuperchattbd.common_messenger.Message

class MessengerDataSourceFactory(
    private val interactor: MessengerDataSourceInteractor
) : DataSource.Factory<Int, Message>() {

    var lastDataSource: DataSource<Int, Message>? = null

    override fun create(): DataSource<Int, Message> {
        return MessengerDataSource(
            interactor
        ).also {
            lastDataSource = it
        }
    }
}
