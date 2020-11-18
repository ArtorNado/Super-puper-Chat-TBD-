package com.example.superpuperchattbd.friends_list.presentation.rv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.superpuperchattbd.R
import com.example.superpuperchattbd.core_db.model.ProfileEntity
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_friend.*

class FriendsRecyclerViewHolder(
    override val containerView: View,
    val click: (ProfileEntity) -> Unit
) :
    RecyclerView.ViewHolder(containerView), LayoutContainer {
    fun bind(profileEntity: ProfileEntity) {
        Glide.with(itemView.context)
            .load(profileEntity.imageUrl)
            .into(ivFriendProfilePic)
        tvFriendName.text = profileEntity.name
        containerView.setOnClickListener { click(profileEntity) }
    }

    companion object {
        fun create(parent: ViewGroup, click: (ProfileEntity) -> Unit) = FriendsRecyclerViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_friend, parent, false
            ), click
        )
    }
}
