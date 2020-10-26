package com.example.superpuperchattbd.messenger.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList
import androidx.paging.RxPagedListBuilder
import com.example.superpuperchattbd.common.base.BaseViewModel
import com.example.superpuperchattbd.messenger.domain.MessengerDataSourceInteractor
import com.example.superpuperchattbd.core_db.model.DialogEntity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MessengerViewModel(
    private val interactor: MessengerDataSourceInteractor
) : BaseViewModel() {

    private val _data = MutableLiveData<PagedList<DialogEntity>>()
    var data: LiveData<PagedList<DialogEntity>> = _data


    init {
        disposables.add(RxPagedListBuilder<Int, DialogEntity>(
            interactor.getData(),
            1
        ).buildObservable()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe { _data.value = it })
    }
}
