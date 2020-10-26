package com.example.superpuperchattbd.core_db.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.superpuperchattbd.core_db.constants.Table
import com.example.superpuperchattbd.core_db.model.DialogEntity
import io.reactivex.Single

@Dao
interface DialogDao {

    @Query("SELECT * FROM ${Table.TABLE_DIALOG}")
    fun getDialogs(): Single<List<DialogEntity>>
}
