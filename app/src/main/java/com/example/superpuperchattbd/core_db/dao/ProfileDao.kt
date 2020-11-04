package com.example.superpuperchattbd.core_db.dao

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.superpuperchattbd.core_db.constants.Table
import com.example.superpuperchattbd.core_db.model.DialogEntity
import com.example.superpuperchattbd.core_db.model.ProfileEntity
import io.reactivex.Completable

@Dao
interface ProfileDao {
    fun getProfile(): DataSource.Factory<Int, ProfileEntity>
}
