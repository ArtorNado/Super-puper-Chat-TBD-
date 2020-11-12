package com.example.superpuperchattbd.friends_list.presentation.rv

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import com.example.superpuperchattbd.core_db.model.ProfileEntity

class FriendsRecyclerAdapter(private val friendsClick: (ProfileEntity) -> Unit) :
    PagedListAdapter<ProfileEntity, FriendsRecyclerViewHolder>(FriendsListDiffUtilCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        FriendsRecyclerViewHolder.create(parent, friendsClick)

    override fun onBindViewHolder(holder: FriendsRecyclerViewHolder, position: Int) =
        holder.bind(getItem(position) as ProfileEntity)
}
