package com.example.superpuperchattbd.app.di

import com.example.superpuperchattbd.app.App
import com.example.superpuperchattbd.app.di.scope.ApplicationScope
import com.example.superpuperchattbd.common.di.navigation.NavigationModule
import com.example.superpuperchattbd.common.di.navigation.RouterModule
import com.example.superpuperchattbd.common.di.viewModel.ViewModelFactoryModule
import com.example.superpuperchattbd.core_db.di.DatabaseModule
import com.example.superpuperchattbd.messenger.di.MessengerFeatureSubcomponent
import com.example.superpuperchattbd.profile.di.ProfileSubcomponent
import com.example.superpuperchattbd.profile_redaction.di.ProfileRedactionSubcomponent
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(
    modules =
    [AppModule::class, ViewModelFactoryModule::class, DatabaseModule::class,
        RouterModule::class, NavigationModule::class]
)
interface AppComponent {

    fun provideMessengerFeatureSubcomponent(): MessengerFeatureSubcomponent.Builder

    fun provideProfileRedactionSubcomponent(): ProfileRedactionSubcomponent.Builder

    fun provideProfileSubcomponent(): ProfileSubcomponent.Builder

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: App): Builder

        fun build(): AppComponent
    }
}
