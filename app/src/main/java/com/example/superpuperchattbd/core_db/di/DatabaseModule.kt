package com.example.superpuperchattbd.core_db.di

import android.content.Context
import androidx.room.Room
import com.example.superpuperchattbd.app.di.scope.ApplicationScope
import com.example.superpuperchattbd.core_db.AppDatabase
import dagger.Module
import dagger.Provides

@Module
class DatabaseModule {

    @Provides
    @ApplicationScope
    fun provideDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(context.applicationContext,
            AppDatabase::class.java, AppDatabase.databaseName)
            .fallbackToDestructiveMigration()
            .build()
    }
}
