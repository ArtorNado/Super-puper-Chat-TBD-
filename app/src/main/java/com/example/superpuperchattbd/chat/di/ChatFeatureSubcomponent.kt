package com.example.superpuperchattbd.chat.di

import androidx.fragment.app.Fragment
import com.example.superpuperchattbd.chat.presentation.ChatFragment
import com.example.superpuperchattbd.messenger.di.scope.MessengerScope
import dagger.BindsInstance
import dagger.Subcomponent

@MessengerScope
@Subcomponent(modules = [ChatFeatureModule::class])
interface ChatFeatureSubcomponent {

    fun inject(chatFragment: ChatFragment)

    @Subcomponent.Builder
    interface Builder {

        @BindsInstance
        fun withFragment(fragment: Fragment): Builder

        fun build(): ChatFeatureSubcomponent
    }
}
