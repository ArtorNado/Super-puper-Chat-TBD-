package com.example.superpuperchattbd.common_messenger.dataSource

import androidx.paging.PositionalDataSource
import com.example.superpuperchattbd.common_messenger.Message

class MessengerDataSource(
    private val interactor: MessengerDataSourceInteractor
) : PositionalDataSource<Message>() {
    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<Message>) {
        TODO("Not yet implemented")
    }

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<Message>) {
        TODO("Not yet implemented")
    }
}

