package com.example.superpuperchattbd.messenger.presentation

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.superpuperchattbd.R
import com.example.superpuperchattbd.app.injector.Injector
import com.example.superpuperchattbd.common.base.BaseFragment
import com.example.superpuperchattbd.common_messenger.recycler.MessengerAdapter
import kotlinx.android.synthetic.main.messenger_fragment.*

class MessengerFragment : BaseFragment<MessengerViewModel>() {

    override val layoutId: Int = R.layout.messenger_fragment

    private var adapter: MessengerAdapter? = null

    override fun inject() {
        Injector.plusMessengerFeatureSubcomponent(this).inject(this)
    }

    override fun initClickListeners() {
        //
    }

    override fun setupViews() {
        tv_test.layoutManager = LinearLayoutManager(context)
    }

    override fun subscribe() {
        viewModel.data.observe(this, Observer { factory ->
            adapter = MessengerAdapter { }
            tv_test.adapter = adapter
            if (factory != null) {
                adapter!!.submitList(factory)
            }
        })
    }

    override fun onDestroy() {
        Injector.clearMessengerFeatureSubcomponent()
        super.onDestroy()
    }

}
