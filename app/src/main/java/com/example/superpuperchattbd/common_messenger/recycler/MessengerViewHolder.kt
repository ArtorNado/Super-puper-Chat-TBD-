package com.example.superpuperchattbd.common_messenger.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.superpuperchattbd.R
import com.example.superpuperchattbd.common_messenger.Dialog
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.dialog_template.view.*

class MessengerViewHolder private constructor(
    override val containerView: View,
    private val onMessageClick: (Dialog) -> Unit
) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun bind(dialog: Dialog) {
        containerView.apply {
            tv_userName.text = dialog.senderName
            tv_message.text = dialog.lastMessage
            tv_time.text = dialog.lastMessageTime
            when(dialog.messageStatus){
                0 -> iv_new.visibility = View.VISIBLE
                1 -> iv_new.visibility = View.GONE
            }
        }
    }

    companion object {
        fun create(parent: ViewGroup, onMessageClick: (Dialog) -> Unit) =
            MessengerViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.dialog_template,
                    parent,
                    false
                ),
                onMessageClick
            )
    }

}
