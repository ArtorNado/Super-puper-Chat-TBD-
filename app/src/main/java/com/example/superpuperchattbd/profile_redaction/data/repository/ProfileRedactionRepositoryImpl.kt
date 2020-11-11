package com.example.superpuperchattbd.profile_redaction.data.repository

import com.example.superpuperchattbd.core_db.AppDatabase
import com.example.superpuperchattbd.core_db.model.ProfileEntity
import io.reactivex.Single
import javax.inject.Inject

class ProfileRedactionRepositoryImpl @Inject constructor(
    private val db: AppDatabase
) : ProfileRedactionRepository {

    override fun getUserData(id: Int): Single<ProfileEntity> = db.profileDao().getProfile()
}