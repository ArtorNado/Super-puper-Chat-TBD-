package com.example.superpuperchattbd.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.superpuperchattbd.common.base.BaseViewModel
import com.example.superpuperchattbd.core_db.model.ProfileEntity
import com.example.superpuperchattbd.messenger.router.MessengerRouter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ProfileViewModel(
    private val interactor: ProfileInteractor
   // private val router: MessengerRouter
) : BaseViewModel() {

    private val _data = MutableLiveData<ProfileEntity>()
    var data: LiveData<ProfileEntity> = _data

    init {
        disposables.add(
            interactor.getData().observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe({
                _data.value = it
            }, {
                it.printStackTrace()
            })
        )
    }
}
