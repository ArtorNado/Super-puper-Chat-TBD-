package com.example.superpuperchattbd.common_messenger.recycler

import android.util.Log
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import com.example.superpuperchattbd.core_db.model.DialogEntity

class MessengerAdapter(
    private val onMessageClick:(DialogEntity) -> Unit
) : PagedListAdapter<DialogEntity, MessengerViewHolder>(
        MessageListDiffUtilCallback
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessengerViewHolder {
        Log.e("onCreateViewHolder", viewType.toString())
        return MessengerViewHolder.create(parent, onMessageClick)
    }

    override fun onBindViewHolder(holder: MessengerViewHolder, position: Int) {
        Log.e("onBindViewHolder", position.toString())
        val item = getItem(position) as DialogEntity
        holder.bind(item)
    }
}
