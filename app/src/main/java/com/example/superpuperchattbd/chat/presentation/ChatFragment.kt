package com.example.superpuperchattbd.chat.presentation

import android.view.MotionEvent
import android.view.View
import android.widget.TextView
import androidx.lifecycle.Observer
import com.example.superpuperchattbd.R
import com.example.superpuperchattbd.app.injector.Injector
import com.example.superpuperchattbd.common.base.BaseFragment
import com.example.superpuperchattbd.common_chat.recycler.MessageAdapter
import com.example.superpuperchattbd.messenger.presentation.MessengerFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.fragment_chat.*

class ChatFragment: BaseFragment<ChatViewModel>() {

    override val layoutId: Int = R.layout.fragment_chat

    private var adapter: MessageAdapter? = null
    private var navView: BottomNavigationView? = null

    private var oldTitle: String? = null

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
                    val text = view as TextView
                    viewModel.sendMessage(text.text.toString())
                    text.text = ""
                    view.performClick()
                }
            }
            false
        }
    }

    override fun setupViews() {
        oldTitle = activity?.title.toString()
        navView = activity?.findViewById(R.id.nav_view)
        navView?.visibility = View.GONE

        adapter = MessageAdapter { viewModel.navigateTo(it) }
        rv_messages.adapter = adapter
    }

    override fun subscribe() {
        viewModel.getDialog(
            arguments?.getInt(MessengerFragment.DIALOG_ID) ?: 0
        )
        observe(viewModel.data, Observer {
            activity?.title = it.senderName
            adapter?.submitList(it.messages)
            if (it.messages.isNotEmpty()) {
                rv_messages.smoothScrollToPosition(it.messages.lastIndex)
            }
        })
    }

    override fun onDestroyView() {
        navView?.visibility = View.VISIBLE
        Injector.clearChatFeatureSubcomponent()
        activity?.title = oldTitle
        super.onDestroyView()
    }

    companion object {
        private const val DRAWABLE_RIGHT_KEY = 2
        const val FEATURE_FLAG = true
        const val PROFILE_ID = "profile_id"
    }
}
