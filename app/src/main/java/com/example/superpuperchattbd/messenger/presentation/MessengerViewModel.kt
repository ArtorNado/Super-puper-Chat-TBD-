package com.example.superpuperchattbd.messenger.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList
import androidx.paging.RxPagedListBuilder
import com.example.superpuperchattbd.common.base.BaseViewModel
import com.example.superpuperchattbd.common.featureflag.FeatureFlags
import com.example.superpuperchattbd.common_messenger.Dialog
import com.example.superpuperchattbd.common_messenger.domain.MessengerDataSourceInteractor
import com.example.superpuperchattbd.messenger.router.MessengerRouter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

private const val PAGE_SIZE = 10

class MessengerViewModel (
    private val interactor: MessengerDataSourceInteractor,
    private val router: MessengerRouter
) : BaseViewModel() {

    private val _data = MutableLiveData<PagedList<Dialog>>()
    var data: LiveData<PagedList<Dialog>> = _data

    init {
        disposables.add(
            interactor.createModels()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe (
                    {  },
                    {  }
                ))

        disposables.add(RxPagedListBuilder<Int, Dialog>(
            interactor.getData(),
            PAGE_SIZE
        ).buildObservable()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe (
                { _data.value = it },
                { Log.e(this.javaClass.name, it.message.toString()) }
            ))
    }

    fun openChat(dialogId: Int) {
        if (FeatureFlags.CHAT_FLAG) {
            router.openChat(dialogId)
        }
    }
}
