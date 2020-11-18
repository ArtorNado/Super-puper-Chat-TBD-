package com.example.superpuperchattbd.chat.di

import androidx.fragment.app.Fragment
import com.example.superpuperchattbd.chat.di.scope.ChatScope
import com.example.superpuperchattbd.chat.presentation.ChatFragment
import dagger.BindsInstance
import dagger.Subcomponent

@ChatScope
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
