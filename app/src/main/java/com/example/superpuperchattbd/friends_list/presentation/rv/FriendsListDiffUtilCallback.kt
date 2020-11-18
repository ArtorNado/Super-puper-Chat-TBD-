package com.example.superpuperchattbd.friends_list.presentation.rv

import androidx.recyclerview.widget.DiffUtil
import com.example.superpuperchattbd.core_db.model.ProfileEntity

object FriendsListDiffUtilCallback : DiffUtil.ItemCallback<ProfileEntity>() {
    override fun areItemsTheSame(oldItem: ProfileEntity, newItem: ProfileEntity) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: ProfileEntity, newItem: ProfileEntity) =
        oldItem == newItem
}
