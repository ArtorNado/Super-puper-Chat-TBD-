package com.example.superpuperchattbd.profile.domain

import com.example.superpuperchattbd.core_db.model.ProfileEntity
import io.reactivex.Single

interface ProfileInteractor {
    fun getData(id: Int): Single<ProfileEntity>
}
