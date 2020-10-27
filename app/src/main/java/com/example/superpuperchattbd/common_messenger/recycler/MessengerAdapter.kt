package com.example.superpuperchattbd.common_messenger.recycler

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import com.example.superpuperchattbd.common_messenger.Dialog

class MessengerAdapter(
    private val onMessageClick: (Dialog) -> Unit
) : PagedListAdapter<Dialog, MessengerViewHolder>(
    DialogListDiffUtilCallback
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessengerViewHolder {
        return MessengerViewHolder.create(parent, onMessageClick)
    }

    override fun onBindViewHolder(holder: MessengerViewHolder, position: Int) {
        val item = getItem(position) as Dialog
        holder.bind(item)
    }
}
