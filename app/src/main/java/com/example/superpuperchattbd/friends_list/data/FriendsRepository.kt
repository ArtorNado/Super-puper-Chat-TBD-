package com.example.superpuperchattbd.friends_list.data

import androidx.paging.DataSource
import com.example.superpuperchattbd.core_db.model.ProfileEntity

interface FriendsRepository {
    fun getData(): DataSource.Factory<Int, ProfileEntity>
}
