package com.example.superpuperchattbd.chat.presentation

import android.os.Build
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.lifecycle.Observer
import com.example.superpuperchattbd.R
import com.example.superpuperchattbd.app.injector.Injector
import com.example.superpuperchattbd.common.base.BaseFragment
import com.example.superpuperchattbd.common_chat.recycler.MessageAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.fragment_chat.*

class ChatFragment: BaseFragment<ChatViewModel>() {

    override val layoutId: Int = R.layout.fragment_chat

    private var adapter: MessageAdapter? = null
    private var navView: BottomNavigationView? = null

    override fun inject() {
        Injector.plusChatFeatureSubcomponent(this).inject(this)
    }

    override fun initClickListeners() {
        et_messages.setOnTouchListener { view, event ->
            if (event.action == MotionEvent.ACTION_UP) {
                if(event.rawX >= (et_messages.right - et_messages.compoundDrawables[2].bounds.width())) {
                    val textView = view as TextView
                    Toast.makeText(
                        this@ChatFragment.context,
                        textView.text.toString(),
                        Toast.LENGTH_LONG
                    ).show()
                    textView.text = ""
                    view.performClick()
                }
            }
            false
        }
    }

    override fun setupViews() {
        navView = activity?.findViewById(R.id.nav_view)
        navView?.visibility = View.GONE

        adapter = MessageAdapter()
        rv_messages.adapter = adapter
    }

    override fun subscribe() {
        viewModel.getDialog(0)
        observe(viewModel.data, Observer {
            adapter?.submitList(it.messages)
        })
    }

    override fun onDestroyView() {
        navView?.visibility = View.VISIBLE
        Injector.clearChatFeatureSubcomponent()
        super.onDestroyView()
    }
}