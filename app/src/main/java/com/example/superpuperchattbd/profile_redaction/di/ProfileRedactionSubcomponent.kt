package com.example.superpuperchattbd.profile_redaction.di

import androidx.fragment.app.Fragment
import com.example.superpuperchattbd.profile_redaction.di.scope.ProfileRedactionScope
import com.example.superpuperchattbd.profile_redaction.presentation.ProfileRedactionFragment
import dagger.BindsInstance
import dagger.Subcomponent

@ProfileRedactionScope
@Subcomponent(modules = [ProfileRedactionModule::class])
interface ProfileRedactionSubcomponent {

    fun inject(profileRedactionFragment: ProfileRedactionFragment)

    @Subcomponent.Builder
    interface Builder {

        @BindsInstance
        fun withFragment(fragment: Fragment): Builder

        fun build(): ProfileRedactionSubcomponent
    }
}