package com.example.superpuperchattbd.friends_list.di

import androidx.fragment.app.Fragment
import com.example.superpuperchattbd.friends_list.presentation.FriendsListFragment
import dagger.BindsInstance
import dagger.Subcomponent

@FriendsScope
@Subcomponent(modules = [FriendsFeatureModule::class])
interface FriendsFeatureSubcomponent {
    fun inject(friendsListFragment: FriendsListFragment)

    @Subcomponent.Builder
    interface Builder {
        @BindsInstance
        fun withFragment(fragment: Fragment): Builder

        fun build(): FriendsFeatureSubcomponent
    }
}
