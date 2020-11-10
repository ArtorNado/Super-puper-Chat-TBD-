package com.example.superpuperchattbd.common_messenger

data class Dialog(
    val id: Int,
    val senderId: Int,
    val imageUrl: String,
    val messages: List<Message>
)
