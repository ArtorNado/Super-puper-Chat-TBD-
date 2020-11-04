package com.example.superpuperchattbd.profile

import androidx.paging.DataSource
import com.example.superpuperchattbd.core_db.AppDatabase
import com.example.superpuperchattbd.core_db.model.ProfileEntity
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(
    private val db: AppDatabase
) : ProfileRepository {
    override fun getData(): DataSource.Factory<Int, ProfileEntity> {
        return db.profileDao().getProfile()
    }
}