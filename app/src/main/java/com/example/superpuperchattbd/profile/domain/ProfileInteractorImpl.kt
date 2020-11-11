package com.example.superpuperchattbd.profile.domain

import com.example.superpuperchattbd.core_db.model.ProfileEntity
import com.example.superpuperchattbd.profile.data.ProfileRepository
import io.reactivex.Single
import javax.inject.Inject

class ProfileInteractorImpl @Inject constructor(
    private val profileRepository: ProfileRepository
) : ProfileInteractor {
    override fun getData(id: Int): Single<ProfileEntity> {
        return profileRepository.getData(id)
    }
}
