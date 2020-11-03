package com.example.superpuperchattbd.common.router

import androidx.navigation.NavController
import javax.inject.Provider

class NavControllerProvider : Provider<NavController?> {

    private var navController: NavController? = null

    override fun get(): NavController? = navController

    fun bind(navController: NavController) {
        this.navController = navController
    }

    fun unbind() {
        this.navController = null
    }
}
