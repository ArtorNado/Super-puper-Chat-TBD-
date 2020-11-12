package com.example.superpuperchattbd.friends_list.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList
import androidx.paging.RxPagedListBuilder
import com.example.superpuperchattbd.common.base.BaseViewModel
import com.example.superpuperchattbd.core_db.model.ProfileEntity
import com.example.superpuperchattbd.friends_list.data.FriendsDataInteractor
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

private const val PAGE_SIZE = 10

class FriendsListViewModel(
    interactor: FriendsDataInteractor
) : BaseViewModel() {
    private val _data = MutableLiveData<PagedList<ProfileEntity>>()
    var data: LiveData<PagedList<ProfileEntity>> = _data

    init {
        disposables.add(
            RxPagedListBuilder<Int, ProfileEntity>(
                interactor.getData(),
                PAGE_SIZE
            ).buildObservable()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe { _data.value = it }
        )
    }
}
