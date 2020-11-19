package com.example.superpuperchattbd.common_messenger

data class Dialog(
    val id: Int,
    val senderId: Int,
    val senderName: String,
    val imageUrl: String,
    val messages: List<Message>
)
