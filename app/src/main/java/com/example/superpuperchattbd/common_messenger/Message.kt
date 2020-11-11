package com.example.superpuperchattbd.common_messenger

import java.util.*

data class Message (
    val userId: Int,
    val message: String,
    val date: Date,
    val messageStatus: Int  //0 if message not read, 1 if message read
)