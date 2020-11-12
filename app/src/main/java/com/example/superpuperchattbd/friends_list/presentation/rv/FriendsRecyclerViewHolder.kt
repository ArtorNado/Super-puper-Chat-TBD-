package com.example.superpuperchattbd.friends_list.presentation.rv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.superpuperchattbd.R
import kotlinx.android.extensions.LayoutContainer

class FriendsRecyclerViewHolder(override val containerView: View) :
    RecyclerView.ViewHolder(containerView), LayoutContainer {
    fun bind() {

    }

    companion object {
        fun create(parent: ViewGroup) = FriendsRecyclerViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_friend, parent, false
            )
        )
    }
}