package com.example.superpuperchattbd.profile_redaction.data.repository

import com.example.superpuperchattbd.core_db.model.ProfileEntity
import io.reactivex.Completable
import io.reactivex.Single

interface ProfileRedactionRepository {

    fun getUserData(id: Int) : Single<ProfileEntity>

    fun saveUserData(profileEntity: ProfileEntity): Completable
}
