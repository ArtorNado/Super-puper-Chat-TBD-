package com.example.superpuperchattbd.app.injector

import com.example.superpuperchattbd.main.MainActivity
import com.example.superpuperchattbd.main.MainActivityFeatureSubcomponent
import com.example.superpuperchattbd.app.App
import com.example.superpuperchattbd.app.di.AppComponent
import com.example.superpuperchattbd.app.di.DaggerAppComponent
import com.example.superpuperchattbd.messenger.di.MessengerFeatureSubcomponent
import com.example.superpuperchattbd.messenger.presentation.MessengerFragment

object Injector {

    lateinit var appComponent: AppComponent

    private var mainActivityFeatureSubcomponent: MainActivityFeatureSubcomponent? = null

    private var messengerFeatureSubcomponent: MessengerFeatureSubcomponent? = null

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

    fun plusMessengerFeatureSubcomponent(fragment: MessengerFragment): MessengerFeatureSubcomponent =
        messengerFeatureSubcomponent
            ?: appComponent.provideMessengerFeatureSubcomponent().withFragment(fragment)
                .build().also {
                    messengerFeatureSubcomponent = it
                }

    fun clearMessengerFeatureSubcomponent() {
        messengerFeatureSubcomponent = null
    }
}

