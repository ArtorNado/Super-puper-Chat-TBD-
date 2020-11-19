package com.example.superpuperchattbd.core_db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.superpuperchattbd.core_db.dao.DialogDao
import com.example.superpuperchattbd.core_db.dao.ProfileDao
import com.example.superpuperchattbd.core_db.model.DialogEntity
import com.example.superpuperchattbd.core_db.model.ProfileEntity

@Database(
    entities = [DialogEntity::class, ProfileEntity::class],
    version = 7,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        const val databaseName = "Super-puper Chat db"
    }

    abstract fun dialogDao(): DialogDao

    abstract fun profileDao(): ProfileDao

}
