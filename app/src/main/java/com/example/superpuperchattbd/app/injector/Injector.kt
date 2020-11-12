package com.example.superpuperchattbd.app.injector

import com.example.superpuperchattbd.app.App
import com.example.superpuperchattbd.app.di.AppComponent
import com.example.superpuperchattbd.app.di.DaggerAppComponent
import com.example.superpuperchattbd.friends_list.di.FriendsFeatureSubcomponent
import com.example.superpuperchattbd.friends_list.presentation.FriendsListFragment
import com.example.superpuperchattbd.messenger.di.MessengerFeatureSubcomponent
import com.example.superpuperchattbd.messenger.presentation.MessengerFragment
import com.example.superpuperchattbd.profile.ProfileFragment
import com.example.superpuperchattbd.profile.ProfileSubcomponent
import com.example.superpuperchattbd.profile_redaction.di.ProfileRedactionSubcomponent
import com.example.superpuperchattbd.profile_redaction.presentation.ProfileRedactionFragment

object Injector {

    lateinit var appComponent: AppComponent

    private var friendsFeatureSubcomponent: FriendsFeatureSubcomponent? = null
    private var messengerFeatureSubcomponent: MessengerFeatureSubcomponent? = null
    private var profileRedactionSubcomponent: ProfileRedactionSubcomponent? = null
    private var profileSubcomponent: ProfileSubcomponent? = null

    fun init(app: App) {
        appComponent = DaggerAppComponent.builder()
            .application(app)
            .build()
    }

    fun plusFriendsFeatureSubcomponent(fragment: FriendsListFragment): FriendsFeatureSubcomponent =
        friendsFeatureSubcomponent ?: appComponent.provideFriendsFeatureSubcomponent()
            .withFragment(fragment).build().also { friendsFeatureSubcomponent = it }

    fun plusMessengerFeatureSubcomponent(fragment: MessengerFragment): MessengerFeatureSubcomponent =
        messengerFeatureSubcomponent
            ?: appComponent.provideMessengerFeatureSubcomponent().withFragment(fragment)
                .build().also {
                    messengerFeatureSubcomponent = it
                }

    fun plusProfileRedactionSubcomponent(fragment: ProfileRedactionFragment): ProfileRedactionSubcomponent =
        profileRedactionSubcomponent ?: appComponent.provideProfileRedactionSubcomponent()
            .withFragment(fragment)
            .build().also {
                profileRedactionSubcomponent = it
            }

    fun plusProfileSubcomponent(fragment: ProfileFragment): ProfileSubcomponent =
        profileSubcomponent ?: appComponent.provideProfileSubcomponent().withFragment(fragment)
            .build().also {
                profileSubcomponent = it
            }

    fun clearMessengerFeatureSubcomponent() {
        messengerFeatureSubcomponent = null
        profileRedactionSubcomponent = null
    }

    fun clearProfileSubcomponent() {
        profileSubcomponent = null
    }
}

