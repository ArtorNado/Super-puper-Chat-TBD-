package com.example.superpuperchattbd.app.di

import com.example.superpuperchattbd.app.App
import com.example.superpuperchattbd.app.di.scope.ApplicationScope
import com.example.superpuperchattbd.common.di.ViewModelFactoryModule
import com.example.superpuperchattbd.core_db.di.DatabaseModule
import com.example.superpuperchattbd.messenger.di.MessengerFeatureSubcomponent
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(
    modules = [AppModule::class, ViewModelFactoryModule::class, DatabaseModule::class]
)
interface AppComponent {

    fun provideMessengerFeatureSubcomponent(): MessengerFeatureSubcomponent.Builder

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: App): Builder

        fun build(): AppComponent
    }
}
