package com.example.superpuperchattbd.core_db.dao

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.superpuperchattbd.core_db.constants.Table
import com.example.superpuperchattbd.core_db.model.ProfileEntity
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface ProfileDao {

    @Query("SELECT * FROM ${Table.TABLE_PROFILE} WHERE id=:userId")
    fun getProfile(userId: Int): Single<ProfileEntity>

    @Query("SELECT * FROM ${Table.TABLE_PROFILE}")
    fun getAllProfiles(): DataSource.Factory<Int, ProfileEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveUserData(profileEntity: ProfileEntity): Completable

    @Insert
    fun createUserData(profileEntity: ProfileEntity): Completable

}
