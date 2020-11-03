package com.example.superpuperchattbd.common.di.navigation

import com.example.superpuperchattbd.app.di.scope.ApplicationScope
import com.example.superpuperchattbd.common.router.NavControllerProvider
import dagger.Module
import dagger.Provides

@Module
object NavigationModule {

    @JvmStatic
    @ApplicationScope
    @Provides
    fun provideNavControllerProvider(): NavControllerProvider = NavControllerProvider()
}
