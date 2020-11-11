package com.example.superpuperchattbd.core_db.type_converters

import androidx.room.TypeConverter
import com.example.superpuperchattbd.common_messenger.Message
import java.lang.StringBuilder
import java.text.SimpleDateFormat
import java.util.*

private const val DATA_FORMAT = "dd-MM-yyyy HH:mm"

class MessageConverter {

    @TypeConverter
    fun fromMessages(messages: List<Message>): String {
        val formatter = SimpleDateFormat(DATA_FORMAT, Locale.ENGLISH)
        val messagesString = StringBuilder()
        messages
            .map { "${it.userId}, ${it.message}, ${formatter.format(it.date)}, ${it.userId}}" }
            .forEach { messagesString.append(it) }
        return messagesString.toString()
    }

    @TypeConverter
    fun toMessages(messages: String): List<Message> {
        val parser =  SimpleDateFormat(DATA_FORMAT, Locale.ENGLISH)
        return messages.split("\n").map {
            val fields = it.split(", ")
            Message(
                userId = fields[USER_ID_KEY].toInt(),
                message = fields[MESSAGE_KEY],
                date = parser.parse(fields[DATE_KEY]) ?: Date(),
                messageStatus = fields[MESSAGE_STATUS_KEY].toInt())
        }
    }

    companion object {

        private const val USER_ID_KEY = 0
        private const val MESSAGE_KEY = 1
        private const val DATE_KEY = 2
        private const val MESSAGE_STATUS_KEY = 3
    }

}
