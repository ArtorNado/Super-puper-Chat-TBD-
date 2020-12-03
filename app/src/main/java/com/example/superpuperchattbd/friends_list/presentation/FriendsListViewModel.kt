package com.example.superpuperchattbd.friends_list.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList
import androidx.paging.RxPagedListBuilder
import com.example.superpuperchattbd.common.base.BaseViewModel
import com.example.superpuperchattbd.common.router.Router
import com.example.superpuperchattbd.core_db.model.DialogEntity
import com.example.superpuperchattbd.core_db.model.ProfileEntity
import com.example.superpuperchattbd.friends_list.data.FriendsDataInteractor
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

private const val PAGE_SIZE = 10

class FriendsListViewModel(
    private val interactor: FriendsDataInteractor,
    private val router: Router
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

    fun friendChosen(friend: ProfileEntity) {
        disposables.add(
            interactor.createNewDialog(
                DialogEntity(
                    0,
                    friend.id,
                    friend.name,
                    friend.imageUrl,
                    emptyList()
                )
            )
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe {
                    interactor.getDialogBySenderId(friend.id)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe({ data -> router.openChat(data.id) }, {})
                }
        )

    }
}
