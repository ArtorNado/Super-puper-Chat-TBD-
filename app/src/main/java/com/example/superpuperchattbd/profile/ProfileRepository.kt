package com.example.superpuperchattbd.profile

import androidx.paging.DataSource
import com.example.superpuperchattbd.core_db.model.ProfileEntity

interface ProfileRepository {
    fun getData(): DataSource.Factory<Int, ProfileEntity>
}