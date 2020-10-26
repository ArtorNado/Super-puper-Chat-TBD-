package com.example.superpuperchattbd.common_messenger.recycler

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import com.example.superpuperchattbd.common_messenger.Message

class MessengerAdapter(
    private val onMessageClick:(Message) -> Unit
) : PagedListAdapter<Message, MessengerViewHolder>(
        MessageListDiffUtilCallback
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessengerViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: MessengerViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}
