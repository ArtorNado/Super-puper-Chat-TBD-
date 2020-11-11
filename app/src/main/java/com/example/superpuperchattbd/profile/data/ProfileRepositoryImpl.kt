package com.example.superpuperchattbd.profile.data

import com.example.superpuperchattbd.core_db.AppDatabase
import com.example.superpuperchattbd.core_db.model.ProfileEntity
import io.reactivex.Single
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(
    private val db: AppDatabase
) : ProfileRepository {
    override fun getData(id: Int): Single<ProfileEntity> {
        return db.profileDao().getProfile(id)
    }
}
