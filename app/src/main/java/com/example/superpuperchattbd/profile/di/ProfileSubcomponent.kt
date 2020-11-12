package com.example.superpuperchattbd.profile.di

import androidx.fragment.app.Fragment
import com.example.superpuperchattbd.profile.presentation.ProfileFragment
import com.example.superpuperchattbd.profile.di.scope.ProfileScope
import dagger.BindsInstance
import dagger.Subcomponent

@ProfileScope
@Subcomponent(modules = [ProfileModule::class])
interface ProfileSubcomponent {

    fun inject(profileFragment: ProfileFragment)

    @Subcomponent.Builder
    interface Builder {

        @BindsInstance
        fun withFragment(fragment: Fragment): Builder

        fun build(): ProfileSubcomponent
    }
}
