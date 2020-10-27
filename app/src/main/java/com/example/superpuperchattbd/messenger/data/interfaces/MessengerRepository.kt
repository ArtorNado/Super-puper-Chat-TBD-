package com.example.superpuperchattbd.messenger.data.interfaces

import androidx.paging.DataSource
import com.example.superpuperchattbd.common_messenger.Dialog

interface MessengerRepository {

    fun getData(): DataSource.Factory<Int, Dialog>
}
