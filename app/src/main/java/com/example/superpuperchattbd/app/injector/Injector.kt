package com.example.superpuperchattbd.app.injector

import com.example.superpuperchattbd.MainActivity
import com.example.superpuperchattbd.MainActivityFeatureSubcomponent
import com.example.superpuperchattbd.app.App
import com.example.superpuperchattbd.app.di.AppComponent
import com.example.superpuperchattbd.app.di.DaggerAppComponent

object Injector {

    lateinit var appComponent: AppComponent

    private var mainActivityFeatureSubcomponent: MainActivityFeatureSubcomponent? = null

    fun init(app: App) {
        appComponent = DaggerAppComponent.builder()
            .application(app)
            .build()
    }

    fun plusMainActivityFeatureSubcomponent(activity: MainActivity): MainActivityFeatureSubcomponent =
        mainActivityFeatureSubcomponent
            ?: appComponent.provideMainActivitySubcomponent().withActivity(activity)
                .build().also {
                    mainActivityFeatureSubcomponent = it
                }

    fun clearMainActivityFeatureSubcomponent() {
        mainActivityFeatureSubcomponent = null
    }
}

