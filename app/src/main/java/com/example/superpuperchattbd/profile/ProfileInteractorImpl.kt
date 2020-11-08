package com.example.superpuperchattbd.profile

import com.example.superpuperchattbd.core_db.model.ProfileEntity
import io.reactivex.Single
import javax.inject.Inject

class ProfileInteractorImpl @Inject constructor(
    private val profileRepository: ProfileRepository
) : ProfileInteractor {
    override fun getData(): Single<ProfileEntity> {
        return profileRepository.getData()
    }
}