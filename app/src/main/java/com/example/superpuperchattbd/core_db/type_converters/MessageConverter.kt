package com.example.superpuperchattbd.core_db.type_converters

import androidx.room.TypeConverter
import com.example.superpuperchattbd.common_messenger.Message
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MessageConverter {

    @TypeConverter
    fun fromMessages(messages: List<Message>): String {
        return Gson().toJson(messages)
    }

    @TypeConverter
    fun toMessages(messages: String): List<Message> {
        val type = object : TypeToken<List<Message>>() {}.type
        val messageList = Gson().fromJson<List<Message>>(messages, type)
        return messageList ?: listOf()
    }
}
