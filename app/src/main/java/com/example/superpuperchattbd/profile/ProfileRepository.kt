package com.example.superpuperchattbd.profile

import com.example.superpuperchattbd.core_db.model.ProfileEntity
import io.reactivex.Single

interface ProfileRepository {
    fun getData(): Single<ProfileEntity>
}
