package com.example.superpuperchattbd.profile.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.superpuperchattbd.common.base.BaseViewModel
import com.example.superpuperchattbd.common.router.Router
import com.example.superpuperchattbd.core_db.model.ProfileEntity
import com.example.superpuperchattbd.profile.domain.ProfileInteractor
import com.example.superpuperchattbd.profile_redaction.presentation.ProfileRedactionFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ProfileViewModel(
    private val interactor: ProfileInteractor,
    private val router: Router
) : BaseViewModel() {
    private val _data = MutableLiveData<ProfileEntity>()
    var data: LiveData<ProfileEntity> = _data

    fun editProfile() {
        if (ProfileRedactionFragment.PROFILE_REDACTION_FLAG) router.editProfile()
    }

    fun getUser(id: Int) {
        disposables.add(
            interactor.getData(id).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe({
                _data.value = it
            }, {
                it.printStackTrace()
            })
        )
    }

    fun refresh(userId: Int) {
        getUser(userId)
    }
}
