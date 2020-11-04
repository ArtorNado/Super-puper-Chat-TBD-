package com.example.superpuperchattbd.profile

import androidx.paging.DataSource
import com.example.superpuperchattbd.core_db.model.ProfileEntity
import javax.inject.Inject

class ProfileInteractorImpl @Inject constructor(
    private val profileRepository: ProfileRepository
) : ProfileInteractor {
    override fun getData(): DataSource.Factory<Int, ProfileEntity> {
        return profileRepository.getData()
    }
}