package com.example.superpuperchattbd.core_db.model

import androidx.room.*
import com.example.superpuperchattbd.common_messenger.Message
import com.example.superpuperchattbd.core_db.type_converters.MessageConverter

@Entity(
    tableName = "dialog",
    foreignKeys = [ForeignKey(
        entity = ProfileEntity::class,
        parentColumns = ["id"],
        childColumns = ["sender_id"],
        onDelete = ForeignKey.CASCADE)]
)
@TypeConverters(MessageConverter::class)
data class DialogEntity(
    @PrimaryKey
    val id: Int,
    @ColumnInfo(name = "sender_id", index = true)
    val senderId: Int,
    val imageUrl: String,
    val messages: List<Message>
)
