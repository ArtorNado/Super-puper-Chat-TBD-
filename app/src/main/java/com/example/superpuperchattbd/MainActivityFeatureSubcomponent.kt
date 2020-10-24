package com.example.superpuperchattbd

import android.app.Activity
import com.example.superpuperchattbd.common.MainActivtyScope
import dagger.BindsInstance
import dagger.Subcomponent

@MainActivtyScope
@Subcomponent(modules = [])
interface MainActivityFeatureSubcomponent{

    fun inject(mainActivity: MainActivity)

    @Subcomponent.Builder
    interface Builder {

        @BindsInstance
        fun withActivity(activity: Activity): Builder

        @BindsInstance
        fun create(teamId: Int): Builder

        fun build(): MainActivityFeatureSubcomponent

    }
}
