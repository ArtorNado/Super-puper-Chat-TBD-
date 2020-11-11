package com.example.superpuperchattbd.common_chat.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.superpuperchattbd.common_chat.MessageType
import com.example.superpuperchattbd.common_messenger.Dialog
import com.example.superpuperchattbd.common_messenger.Message

class MessageAdapter(
) : ListAdapter<Message, MessageViewHolder>(
    MessagesListDiffUtilCallback
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        return when(viewType) {
            0 -> MessageViewHolder.create(parent, MessageType.Currant)
            else -> MessageViewHolder.create(parent, MessageType.Sender)
        }
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val item = getItem(position) as Message
        holder.bind(item)
    }

    override fun getItemViewType(position: Int): Int {
        if (currentList[position].userId != 1) {
            return 1
        } else {
            return super.getItemViewType(position)
        }
    }
}
