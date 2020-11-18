package com.example.superpuperchattbd.core_db.dao

import androidx.paging.DataSource
import androidx.room.*
import com.example.superpuperchattbd.core_db.constants.Table
import com.example.superpuperchattbd.core_db.model.DialogEntity
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface DialogDao {

    @Query("SELECT * FROM ${Table.TABLE_DIALOG}")
    fun getDialogs(): DataSource.Factory<Int, DialogEntity>

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun setDialog(dialog: DialogEntity): Completable

    @Query("SELECT * FROM ${Table.TABLE_DIALOG} WHERE id=:id")
    fun getDialogById(id: Int): Single<DialogEntity>

    @Query("SELECT * FROM ${Table.TABLE_DIALOG} WHERE sender_id=:id")
    fun getDialogBySenderId(id: Int): DialogEntity

    @Query("SELECT * FROM ${Table.TABLE_DIALOG} WHERE id=:id")
    fun getDialogByIdNotSingle(id: Int): DialogEntity

    @Update
    fun sendMessage(dialog: DialogEntity): Completable
}
