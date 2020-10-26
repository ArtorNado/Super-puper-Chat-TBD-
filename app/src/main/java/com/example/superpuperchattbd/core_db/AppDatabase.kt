package com.example.superpuperchattbd.core_db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.superpuperchattbd.core_db.dao.DialogDao
import com.example.superpuperchattbd.core_db.model.DialogEntity

@Database(
    entities = [DialogEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        const val databaseName = "Super-puper Chat db"
    }

    abstract fun dialogDao(): DialogDao

}
