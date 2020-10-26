package com.example.superpuperchattbd.common_messenger.recycler

import androidx.recyclerview.widget.DiffUtil
import com.example.superpuperchattbd.core_db.model.DialogEntity

object MessageListDiffUtilCallback : DiffUtil.ItemCallback<DialogEntity>() {

    override fun areItemsTheSame(oldItem: DialogEntity, newItem: DialogEntity): Boolean {
        return oldItem.id == newItem.id &&
                oldItem.lastMessage == newItem.lastMessage &&
                oldItem.lastMessageTime == newItem.lastMessageTime
    }

    override fun areContentsTheSame(oldItem: DialogEntity, newItem: DialogEntity): Boolean {
        return oldItem == newItem
    }
}
