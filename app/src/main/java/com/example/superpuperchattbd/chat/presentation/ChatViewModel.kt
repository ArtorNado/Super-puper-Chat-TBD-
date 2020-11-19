package com.example.superpuperchattbd.chat.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.superpuperchattbd.chat.router.ChatRouter
import com.example.superpuperchattbd.common.base.BaseViewModel
import com.example.superpuperchattbd.common_chat.domain.ChatInteractor
import com.example.superpuperchattbd.common_messenger.Dialog
import com.example.superpuperchattbd.common_messenger.Message
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ChatViewModel @Inject constructor(
    private val interactor: ChatInteractor,
    private val router: ChatRouter
) : BaseViewModel() {

    private val _data = MutableLiveData<Dialog>()
    var data: LiveData<Dialog> = _data

    fun getDialog(id: Int) {
        disposables.add(
            interactor.getData(id)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe (
                { _data.value = it
                    Log.e(this@ChatViewModel.javaClass.name + " getDialog", it.toString())
                },
                { Log.e(this@ChatViewModel.javaClass.name + " getDialog", it.message.toString()) }
            ))
    }

    fun sendMessage(message: String) {
        disposables.add(
            interactor.sendMessage(_data.value, message)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                    { _data.value = it },
                    {
                        Log.e(
                            this@ChatViewModel.javaClass.name + " sendMessage",
                            it.message.toString()
                        )
                    }
                ))
    }

    fun navigateTo(message: Message) {
        router.openProfile(message.userId)
    }
}
