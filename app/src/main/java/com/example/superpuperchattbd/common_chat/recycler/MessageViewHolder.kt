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
    override val containerView: View,
    private val onClickImage: (Message) -> Unit
) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun bind(message: Message) {
        containerView.apply {
            tv_data.text = message.date.run {
                hours.let { if (it < FORMAT_TIME) "0$it:" else "$it:" } +
                minutes.let { if (it < FORMAT_TIME) "0$it" else "$it" }
            }
            tv_message.text = message.message
            iv_ava.setOnClickListener { onClickImage.invoke(message) }
        }
    }

    companion object {

        private const val FORMAT_TIME = 10

        fun create(
            parent: ViewGroup,
            onClickImage: (Message) -> Unit,
            messageType: MessageType
        ): MessageViewHolder {
            return when (messageType) {
                MessageType.Currant -> MessageViewHolder(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.message_template,
                        parent,
                        false
                    ),
                    onClickImage
                )
                MessageType.Sender -> MessageViewHolder(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.message_sender_template,
                        parent,
                        false
                    ),
                    onClickImage
                )
            }
        }
    }

}
