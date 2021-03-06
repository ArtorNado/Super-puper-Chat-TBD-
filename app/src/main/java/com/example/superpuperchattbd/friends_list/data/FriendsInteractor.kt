package com.example.superpuperchattbd.friends_list.data

import androidx.paging.DataSource
import com.example.superpuperchattbd.core_db.model.DialogEntity
import com.example.superpuperchattbd.core_db.model.ProfileEntity
import io.reactivex.Single
import javax.inject.Inject

class FriendsInteractor @Inject constructor(
    val repository: FriendsRepository
) : FriendsDataInteractor {
    override fun getData(): DataSource.Factory<Int, ProfileEntity> {
        return repository.getData()
    }

    override fun createNewDialog(dialogEntity: DialogEntity) =
        repository.createNewDialog(dialogEntity)

    override fun getDialogBySenderId(id: Int): Single<DialogEntity> =
        repository.getDialogBySenderId(id)

}
