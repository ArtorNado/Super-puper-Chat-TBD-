package com.example.superpuperchattbd.common_chat.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.superpuperchattbd.R
import com.example.superpuperchattbd.common_chat.MessageType
import com.example.superpuperchattbd.common_messenger.Message
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.message_template.view.*

class MessageViewHolder private constructor(
    override val containerView: View
) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun bind(message: Message) {
        containerView.apply {
            tv_data.text = message.date.run {
                hours.let { if (it < 10) "0$it:" else "$it:" } +
                minutes.let { if (it < 10) "0$it" else "$it" }
            }
            tv_message.text = message.message
        }
    }

    companion object {
        fun create(parent: ViewGroup, messageType: MessageType) =
            when(messageType) {
                MessageType.Currant -> MessageViewHolder(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.message_template,
                        parent,
                        false
                    )
                )
                MessageType.Sender ->  MessageViewHolder(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.message_sender_template,
                        parent,
                        false
                    )
                )
            }
    }

}
