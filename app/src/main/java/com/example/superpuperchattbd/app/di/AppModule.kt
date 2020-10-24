package com.example.superpuperchattbd.app.di

import android.content.Context
import com.example.superpuperchattbd.app.App
import com.example.superpuperchattbd.app.di.scope.ApplicationScope
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @ApplicationScope
    @Provides
    fun bindContext(application: App): Context = application.applicationContext
}
