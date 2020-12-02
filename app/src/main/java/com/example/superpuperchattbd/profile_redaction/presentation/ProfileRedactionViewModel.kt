package com.example.superpuperchattbd.profile_redaction.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.superpuperchattbd.common.base.BaseViewModel
import com.example.superpuperchattbd.core_db.model.ProfileEntity
import com.example.superpuperchattbd.profile_redaction.domain.ProfileRedactionInteractor
import com.example.superpuperchattbd.profile_redaction.router.ProfileRedactionRouter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ProfileRedactionViewModel(
    private val interactor: ProfileRedactionInteractor,
    private val router: ProfileRedactionRouter
) : BaseViewModel() {

    var imageUrl: String? = null

    private val _data = MutableLiveData<ProfileEntity>()
    var data: LiveData<ProfileEntity> = _data

    private val _navigateToProfile = MutableLiveData<Boolean>()
    var navigateToProfile: LiveData<Boolean> = _navigateToProfile

    fun getUserData() {
        val currentUserId = 0
        disposables.add(
            interactor.getUserData(currentUserId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                    {
                        _data.value = it
                        imageUrl = it.imageUrl
                    }, {
                        it.printStackTrace()
                    }
                )
        )
    }

    fun saveUserData(profileEntity: ProfileEntity) {
        disposables.add(
            interactor.saveUserData(profileEntity)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnComplete {
                    _navigateToProfile.value = true
                }
                .subscribe(
                    {

                    }, {
                        it.printStackTrace()
                    }
                )
        )
    }

    fun navigateToProfile() {
        router.backToProfile()
    }
}
