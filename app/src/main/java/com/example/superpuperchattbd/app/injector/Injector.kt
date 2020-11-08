package com.example.superpuperchattbd.app.injector

import com.example.superpuperchattbd.app.App
import com.example.superpuperchattbd.app.di.AppComponent
import com.example.superpuperchattbd.app.di.DaggerAppComponent
import com.example.superpuperchattbd.messenger.di.MessengerFeatureSubcomponent
import com.example.superpuperchattbd.messenger.presentation.MessengerFragment
import com.example.superpuperchattbd.profile_redaction.di.ProfileRedactionSubcomponent
import com.example.superpuperchattbd.profile_redaction.presentation.ProfileRedactionFragment

object Injector {

    lateinit var appComponent: AppComponent

    private var messengerFeatureSubcomponent: MessengerFeatureSubcomponent? = null
    private var profileRedactionSubcomponent: ProfileRedactionSubcomponent? = null

    fun init(app: App) {
        appComponent = DaggerAppComponent.builder()
            .application(app)
            .build()
    }

    fun plusMessengerFeatureSubcomponent(fragment: MessengerFragment): MessengerFeatureSubcomponent =
        messengerFeatureSubcomponent
            ?: appComponent.provideMessengerFeatureSubcomponent().withFragment(fragment)
                .build().also {
                    messengerFeatureSubcomponent = it
                }

    fun plusProfileRedactionSubcomponent(fragment: ProfileRedactionFragment): ProfileRedactionSubcomponent =
        profileRedactionSubcomponent ?: appComponent.provideProfileRedactionSubcomponent().withFragment(fragment)
            .build().also {
                profileRedactionSubcomponent = it
            }

    fun clearMessengerFeatureSubcomponent() {
        messengerFeatureSubcomponent = null
        profileRedactionSubcomponent = null
    }
}

