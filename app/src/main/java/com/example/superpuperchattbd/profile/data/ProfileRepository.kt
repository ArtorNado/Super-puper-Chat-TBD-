package com.example.superpuperchattbd.profile.data

import com.example.superpuperchattbd.core_db.model.ProfileEntity
import io.reactivex.Single

interface ProfileRepository {
    fun getData(id: Int): Single<ProfileEntity>
}
