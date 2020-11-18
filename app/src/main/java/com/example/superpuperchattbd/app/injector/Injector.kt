package com.example.superpuperchattbd.app.injector

import com.example.superpuperchattbd.app.App
import com.example.superpuperchattbd.app.di.AppComponent
import com.example.superpuperchattbd.app.di.DaggerAppComponent
import com.example.superpuperchattbd.friends_list.di.FriendsFeatureSubcomponent
import com.example.superpuperchattbd.friends_list.presentation.FriendsListFragment
import com.example.superpuperchattbd.chat.di.ChatFeatureSubcomponent
import com.example.superpuperchattbd.chat.presentation.ChatFragment
import com.example.superpuperchattbd.main.MainActivity
import com.example.superpuperchattbd.main.di.MainActivitySubcomponent
import com.example.superpuperchattbd.messenger.di.MessengerFeatureSubcomponent
import com.example.superpuperchattbd.messenger.presentation.MessengerFragment
import com.example.superpuperchattbd.profile.presentation.ProfileFragment
import com.example.superpuperchattbd.profile.di.ProfileSubcomponent
import com.example.superpuperchattbd.profile_redaction.di.ProfileRedactionSubcomponent
import com.example.superpuperchattbd.profile_redaction.presentation.ProfileRedactionFragment

object Injector {

    lateinit var appComponent: AppComponent

    private var mainActivitySubcomponent: MainActivitySubcomponent? = null
    private var friendsFeatureSubcomponent: FriendsFeatureSubcomponent? = null
    private var messengerFeatureSubcomponent: MessengerFeatureSubcomponent? = null
    private var profileRedactionSubcomponent: ProfileRedactionSubcomponent? = null
    private var profileSubcomponent: ProfileSubcomponent? = null
    private var chatFeatureSubcomponent: ChatFeatureSubcomponent? = null

    fun init(app: App) {
        appComponent = DaggerAppComponent.builder()
            .application(app)
            .build()
    }

    fun plusMainActivitySubcomponent(activity: MainActivity): MainActivitySubcomponent =
        mainActivitySubcomponent ?: appComponent.provideMainAcitivtySubComponent()
            .withActivity(activity).build().also { mainActivitySubcomponent = it  }

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
    }

    fun clearProfileRedactionSubcomponent() {
        profileRedactionSubcomponent = null
    }

    fun clearProfileSubcomponent() {
        profileSubcomponent = null
    }

    fun clearMainActivitySubcomponent() {
        mainActivitySubcomponent = null
    }

    fun plusChatFeatureSubcomponent(fragment: ChatFragment): ChatFeatureSubcomponent =
        chatFeatureSubcomponent
            ?: appComponent.provideChatFeatureSubcomponent().withFragment(fragment)
                .build().also {
                    chatFeatureSubcomponent = it
                }

    fun clearChatFeatureSubcomponent() {
        chatFeatureSubcomponent = null
    }


}

