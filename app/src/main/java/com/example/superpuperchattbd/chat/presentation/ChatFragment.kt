package com.example.superpuperchattbd.chat.presentation

import com.example.superpuperchattbd.common.base.BaseFragment
import com.example.superpuperchattbd.R
import com.example.superpuperchattbd.app.injector.Injector

class ChatFragment: BaseFragment<ChatViewModel>() {

    override val layoutId: Int = R.layout.fragment_chat

    override fun inject() {
        Injector.plusChatFeatureSubcomponent(this).inject(this)
    }

    override fun initClickListeners() {
        //TODO
    }

    override fun setupViews() {
        TODO("Not yet implemented")
    }

    override fun subscribe() {
        TODO("Not yet implemented")
    }
}