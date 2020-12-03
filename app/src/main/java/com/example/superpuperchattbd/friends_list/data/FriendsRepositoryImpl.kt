package com.example.superpuperchattbd.friends_list.data

import androidx.paging.DataSource
import com.example.superpuperchattbd.core_db.AppDatabase
import com.example.superpuperchattbd.core_db.model.DialogEntity
import com.example.superpuperchattbd.core_db.model.ProfileEntity
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class FriendsRepositoryImpl @Inject constructor(private val db: AppDatabase) : FriendsRepository {
    override fun getData(): DataSource.Factory<Int, ProfileEntity> =
        db.profileDao().getAllProfiles()

    override fun createNewDialog(dialogEntity: DialogEntity): Completable =
        db.dialogDao().createDialog(dialogEntity)

    override fun getDialogBySenderId(id: Int): Single<DialogEntity> =
        db.dialogDao().getDialogBySenderId(id)
}
