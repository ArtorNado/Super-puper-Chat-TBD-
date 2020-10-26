package com.example.superpuperchattbd.core_db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dialog")
data class DialogEntity(
    @PrimaryKey
    val id: Int,
    val interlocutorName: String,
    val lastMessage: String,
    val lastMessageTime: String,
    val imageUrl: String,
    val lastMessageStatus: Int
)
