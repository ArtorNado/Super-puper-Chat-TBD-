package com.example.superpuperchattbd.core_db.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.superpuperchattbd.core_db.constants.Table
import com.example.superpuperchattbd.core_db.model.ProfileEntity
import io.reactivex.Single

@Dao
interface ProfileDao {

    @Query ("SELECT * FROM ${Table.TABLE_PROFILE}")
    fun getProfile(): Single<ProfileEntity>
}
