package com.example.superpuperchattbd.friends_list.data

import androidx.paging.DataSource
import com.example.superpuperchattbd.core_db.AppDatabase
import com.example.superpuperchattbd.core_db.model.ProfileEntity
import javax.inject.Inject

class FriendsRepositoryImpl @Inject constructor(private val db: AppDatabase) : FriendsRepository {
    override fun getData(): DataSource.Factory<Int, ProfileEntity> =
        db.profileDao().getAllProfiles()
}
