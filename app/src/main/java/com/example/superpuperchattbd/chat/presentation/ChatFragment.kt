package com.example.superpuperchattbd.chat.presentation

import android.view.MotionEvent
import android.view.View
import android.widget.TextView
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
                val position = et_messages.run {
                    right - compoundDrawables[DRAWABLE_RIGHT_KEY].bounds.width()
                }
                if (event.rawX >= position) {
                    val textView = view as TextView
                    viewModel.sendMessage(textView.text.toString())
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
        viewModel.getDialog(
            arguments?.getInt(ID_ARG) ?: 0
        )
        observe(viewModel.data, Observer {
            viewModel.getProfile(it.senderId)
            adapter?.submitList(it.messages)
        })
        observe(viewModel.profile, Observer {
            activity?.actionBar?.title = it.name
        })
    }

    override fun onDestroyView() {
        navView?.visibility = View.VISIBLE
        Injector.clearChatFeatureSubcomponent()
        super.onDestroyView()
    }

    companion object {
        private const val DRAWABLE_RIGHT_KEY = 2
        private const val ID_ARG = "id_arg"
    }
}
