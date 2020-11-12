package com.example.superpuperchattbd.friends_list.data

import androidx.paging.DataSource
import com.example.superpuperchattbd.core_db.model.ProfileEntity
import javax.inject.Inject

class FriendsInteractor @Inject constructor(
    val repository: FriendsRepository
) : FriendsDataInteractor {
    override fun getData(): DataSource.Factory<Int, ProfileEntity> {
        return repository.getData()
    }
}
