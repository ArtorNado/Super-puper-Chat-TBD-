package com.example.superpuperchattbd.core_db.type_converters

import androidx.room.TypeConverter
import com.example.superpuperchattbd.common_messenger.Message
import java.lang.StringBuilder
import java.text.SimpleDateFormat
import java.util.*

private const val patter = "dd-MM-yyyy HH:mm"

class MessageConverter {

    @TypeConverter
    fun fromMessages(messages: List<Message>): String {
        val formatter = SimpleDateFormat(patter, Locale.ENGLISH)
        val messagesString = StringBuilder()
        messages
            .map { "${it.userId}, ${it.message}, ${formatter.format(it.date)}, ${it.userId}}" }
            .forEach { messagesString.append(it) }
        return messagesString.toString()
    }

    @TypeConverter
    fun toMessages(messages: String): List<Message> {
        val parser =  SimpleDateFormat(patter, Locale.ENGLISH)
        return messages.split("\n").map {
            val fields = it.split(", ")
            Message(
                userId = fields[0].toInt(),
                message = fields[1],
                date = parser.parse(fields[2]) ?: Date(),
                messageStatus = fields[3].toInt())
        }
    }

}
