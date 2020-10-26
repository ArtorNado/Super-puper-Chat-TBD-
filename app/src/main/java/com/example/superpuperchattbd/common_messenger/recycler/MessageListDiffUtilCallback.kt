package com.example.superpuperchattbd.common_messenger.recycler

import androidx.recyclerview.widget.DiffUtil
import com.example.superpuperchattbd.common_messenger.Message

object MessageListDiffUtilCallback : DiffUtil.ItemCallback<Message>() {
    override fun areItemsTheSame(oldItem: Message, newItem: Message): Boolean {
        return oldItem.id == newItem.id &&
                oldItem.lastMessage == newItem.lastMessage &&
                oldItem.lastMessageTime == newItem.lastMessageTime
    }

    override fun areContentsTheSame(oldItem: Message, newItem: Message): Boolean {
        return oldItem == newItem
    }
}
