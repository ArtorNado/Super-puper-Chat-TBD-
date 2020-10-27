package com.example.superpuperchattbd.core_db.dao

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.superpuperchattbd.core_db.constants.Table
import com.example.superpuperchattbd.core_db.model.DialogEntity
import io.reactivex.Completable

@Dao
interface DialogDao {

    @Query("SELECT * FROM ${Table.TABLE_DIALOG} ORDER BY lastMessageTime ASC")
    fun getDialogs(): DataSource.Factory<Int, DialogEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun setDialog(dialog: DialogEntity): Completable
}
