package com.example.superpuperchattbd.common.di.navigation

import com.example.superpuperchattbd.app.di.scope.ApplicationScope
import com.example.superpuperchattbd.common.router.RouterImpl
import com.example.superpuperchattbd.messenger.router.MessengerRouter
import dagger.Binds
import dagger.Module

@Module
abstract class RouterModule {

    @ApplicationScope
    @Binds
    abstract fun bindMessengerRouter(router: RouterImpl): MessengerRouter
}
