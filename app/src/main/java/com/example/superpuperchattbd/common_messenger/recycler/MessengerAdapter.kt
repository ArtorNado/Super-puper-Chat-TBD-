package com.example.superpuperchattbd.common_messenger.recycler

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import com.example.superpuperchattbd.core_db.model.DialogEntity

class MessengerAdapter(
    private val onMessageClick: (DialogEntity) -> Unit
) : PagedListAdapter<DialogEntity, MessengerViewHolder>(
    DialogListDiffUtilCallback
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessengerViewHolder {
        return MessengerViewHolder.create(parent, onMessageClick)
    }

    override fun onBindViewHolder(holder: MessengerViewHolder, position: Int) {
        val item = getItem(position) as DialogEntity
        holder.bind(item)
    }
}
