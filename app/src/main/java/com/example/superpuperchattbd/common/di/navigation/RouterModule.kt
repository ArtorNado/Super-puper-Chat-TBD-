package com.example.superpuperchattbd.common.di.navigation

import com.example.superpuperchattbd.app.di.scope.ApplicationScope
import com.example.superpuperchattbd.common.router.Router
import com.example.superpuperchattbd.common.router.RouterImpl
import com.example.superpuperchattbd.messenger.router.MessengerRouter
import com.example.superpuperchattbd.profile_redaction.router.ProfileRedactionRouter
import dagger.Binds
import dagger.Module

@Module
abstract class RouterModule {

    @ApplicationScope
    @Binds
    abstract fun bindMessengerRouter(router: RouterImpl): MessengerRouter

    @ApplicationScope
    @Binds
    abstract fun bindProfileRedactionRouter(router: RouterImpl): ProfileRedactionRouter

    //Сорян, но имхо разделять роутер на куски это уже кринж (C)Эмиль
    @ApplicationScope
    @Binds
    abstract fun bindWholeRouter(router: RouterImpl): Router
}
