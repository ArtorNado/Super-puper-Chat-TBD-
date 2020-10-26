package com.example.superpuperchattbd.common_messenger.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.superpuperchattbd.R
import com.example.superpuperchattbd.core_db.model.DialogEntity
import kotlinx.android.extensions.LayoutContainer

class MessengerViewHolder private constructor(
    override val containerView: View,
    private val onMessageClick: (DialogEntity) -> Unit
) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun bind(dialogEntity: DialogEntity) {
    }

    companion object {
        fun create(parent: ViewGroup, onMessageClick: (DialogEntity) -> Unit) =
            MessengerViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.dialog_template,
                    parent,
                    false
                ),
                onMessageClick
            )
    }

}
