package com.example.superpuperchattbd.common_messenger.recycler

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.superpuperchattbd.common_messenger.Message
import kotlinx.android.extensions.LayoutContainer

class MessengerViewHolder private constructor(
    override val containerView: View,
    private val onMessageClick: (Message) -> Unit
) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun bind(){

    }

    companion object {
        /*fun create(parent: ViewGroup, onMessageClick: (Message) -> Unit) = {
            MessengerViewHolder(

            )
        }*/
    }
}
