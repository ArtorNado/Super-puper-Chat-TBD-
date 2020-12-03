package com.example.superpuperchattbd.friends_list.data

import androidx.paging.DataSource
import com.example.superpuperchattbd.core_db.model.DialogEntity
import com.example.superpuperchattbd.core_db.model.ProfileEntity
import io.reactivex.Completable
import io.reactivex.Single

interface FriendsRepository {
    fun getData(): DataSource.Factory<Int, ProfileEntity>

    fun createNewDialog(dialogEntity: DialogEntity): Completable

    fun getDialogBySenderId(id: Int): Single<DialogEntity>
}
