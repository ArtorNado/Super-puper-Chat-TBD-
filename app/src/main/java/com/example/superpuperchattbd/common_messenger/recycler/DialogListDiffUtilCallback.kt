package com.example.superpuperchattbd.common_messenger.recycler

import androidx.recyclerview.widget.DiffUtil
import com.example.superpuperchattbd.common_messenger.Dialog

object DialogListDiffUtilCallback : DiffUtil.ItemCallback<Dialog>() {

    override fun areItemsTheSame(oldItem: Dialog, newItem: Dialog): Boolean {
        return oldItem.id == newItem.id &&
                oldItem.messages == newItem.messages
    }

    override fun areContentsTheSame(oldItem: Dialog, newItem: Dialog): Boolean {
        return oldItem == newItem
    }
}
