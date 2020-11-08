package com.example.superpuperchattbd.profile_redaction.domain

import com.example.superpuperchattbd.core_db.model.ProfileEntity
import com.example.superpuperchattbd.profile_redaction.data.repository.ProfileRedactionRepository
import io.reactivex.Single
import javax.inject.Inject

class ProfileRedactionInteractorImpl @Inject constructor(
    private val repository: ProfileRedactionRepository
): ProfileRedactionInteractor {

    override fun getUserData(id: Int): Single<ProfileEntity> = repository.getUserData(id)
}