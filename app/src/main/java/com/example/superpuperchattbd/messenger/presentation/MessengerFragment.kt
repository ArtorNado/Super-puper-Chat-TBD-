package com.example.superpuperchattbd.messenger.presentation

import com.example.superpuperchattbd.R
import com.example.superpuperchattbd.app.injector.Injector
import com.example.superpuperchattbd.common.base.BaseFragment

class MessengerFragment : BaseFragment<MessengerViewModel>() {

    override val layoutId: Int = R.layout.messenger_fragment

    override fun inject() {
        Injector.plusMessengerFeatureSubcomponent(this).inject(this)
    }

    override fun initClickListeners() {
        //
    }

    override fun setupViews() {
        //
    }

    override fun subscribe() {
        //
    }

    override fun onDestroy() {
        Injector.clearMessengerFeatureSubcomponent()
        super.onDestroy()
    }

}
