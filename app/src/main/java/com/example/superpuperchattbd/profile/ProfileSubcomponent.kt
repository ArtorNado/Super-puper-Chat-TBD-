package com.example.superpuperchattbd.profile

import androidx.fragment.app.Fragment
import com.example.superpuperchattbd.profile_redaction.di.ProfileRedactionModule
import com.example.superpuperchattbd.profile_redaction.di.ProfileRedactionSubcomponent
import com.example.superpuperchattbd.profile_redaction.di.scope.ProfileRedactionScope
import com.example.superpuperchattbd.profile_redaction.presentation.ProfileRedactionFragment
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