package com.example.superpuperchattbd.friends_list.presentation.rv

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.superpuperchattbd.core_db.model.ProfileEntity

class FriendsRecyclerAdapter(var dataSrc: List<ProfileEntity>) :
    RecyclerView.Adapter<FriendsRecyclerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        FriendsRecyclerViewHolder.create(parent)

    override fun onBindViewHolder(holder: FriendsRecyclerViewHolder, position: Int) =
        holder.bind(dataSrc[position])

    override fun getItemCount() = dataSrc.size
}
