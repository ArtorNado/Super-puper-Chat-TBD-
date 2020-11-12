package com.example.superpuperchattbd.common_chat.recycler

import androidx.recyclerview.widget.DiffUtil
import com.example.superpuperchattbd.common_messenger.Message

object MessagesListDiffUtilCallback : DiffUtil.ItemCallback<Message>() {

    override fun areItemsTheSame(oldItem: Message, newItem: Message): Boolean {
        return oldItem.message == newItem.message &&
                oldItem.date == newItem.date &&
                oldItem.messageStatus == newItem.messageStatus &&
                oldItem.userId == newItem.userId
    }

    override fun areContentsTheSame(oldItem: Message, newItem: Message): Boolean {
        return oldItem == newItem
    }
}
