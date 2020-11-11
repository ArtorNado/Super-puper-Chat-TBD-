package com.example.superpuperchattbd.profile_redaction.domain

import com.example.superpuperchattbd.core_db.model.ProfileEntity
import io.reactivex.Completable
import io.reactivex.Single

interface ProfileRedactionInteractor {

    fun getUserData(id: Int): Single<ProfileEntity>

    fun saveUserData(profileEntity: ProfileEntity): Completable
}