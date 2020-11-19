package com.example.superpuperchattbd.common_chat.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.superpuperchattbd.common_chat.MessageType
import com.example.superpuperchattbd.common_messenger.Message

class MessageAdapter(
    private val onClickImage: (Message) -> Unit
) : ListAdapter<Message, MessageViewHolder>(MessagesListDiffUtilCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        return when(viewType) {
            0 -> MessageViewHolder.create(parent, onClickImage, MessageType.Currant)
            else -> MessageViewHolder.create(parent, onClickImage, MessageType.Sender)
        }
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val item = getItem(position) as Message
        holder.bind(item)
    }

    override fun getItemViewType(position: Int): Int {
        if (currentList[position].userId == 0) {
            return 0
        } else {
            return -1
        }
    }
}
