package com.example.superpuperchattbd.core_db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "profile")
data class ProfileEntity (
    @PrimaryKey
    val id: Int,
    val name: String,
    val age: Int,
    val email: String,
    val about: String,
    val status: String,
    val imageUrl: String
)