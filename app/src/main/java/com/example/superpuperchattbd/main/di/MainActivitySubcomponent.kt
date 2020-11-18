package com.example.superpuperchattbd.main.di

import androidx.appcompat.app.AppCompatActivity
import com.example.superpuperchattbd.main.MainActivity
import com.example.superpuperchattbd.main.di.scope.MainScope
import dagger.BindsInstance
import dagger.Subcomponent

@MainScope
@Subcomponent
interface MainActivitySubcomponent {

    fun inject(mainActivity: MainActivity)

    @Subcomponent.Builder
    interface Builder {

        @BindsInstance
        fun withActivity(activity: AppCompatActivity): Builder

        fun build(): MainActivitySubcomponent
    }
}
