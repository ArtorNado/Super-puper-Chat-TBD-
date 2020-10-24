package com.example.superpuperchattbd.app.di

import com.example.superpuperchattbd.main.MainActivityFeatureSubcomponent
import com.example.superpuperchattbd.app.App
import com.example.superpuperchattbd.app.di.scope.ApplicationScope
import com.example.superpuperchattbd.common.di.ViewModelFactoryModule
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(
    modules = [AppModule::class, ViewModelFactoryModule::class]
)
interface AppComponent {

    fun provideMainActivitySubcomponent(): MainActivityFeatureSubcomponent.Builder

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: App): Builder

        fun build(): AppComponent
    }
}
