package com.example.superpuperchattbd.common_messenger

data class Dialog(
    val id: Int,
    val senderName: String,
    val lastMessage: String,
    val lastMessageTime: String,
    val imageUrl: String,
    val messageStatus: Int  //0 if message not read, 1 if message read
)
