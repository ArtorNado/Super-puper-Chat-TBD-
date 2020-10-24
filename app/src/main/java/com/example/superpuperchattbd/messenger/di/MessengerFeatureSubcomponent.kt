package com.example.superpuperchattbd.messenger.di

import androidx.fragment.app.Fragment
import com.example.superpuperchattbd.messenger.di.scope.MessengerScope
import com.example.superpuperchattbd.messenger.presentation.MessengerFragment
import dagger.BindsInstance
import dagger.Subcomponent

@MessengerScope
@Subcomponent(modules = [MessengerFeatureModule::class])
interface MessengerFeatureSubcomponent {

    fun inject(messengerFragment: MessengerFragment)

    @Subcomponent.Builder
    interface Builder {

        @BindsInstance
        fun withFragment(fragment: Fragment): Builder

        fun build(): MessengerFeatureSubcomponent
    }
}
