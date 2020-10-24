package com.example.superpuperchattbd.app

import android.app.Application
import com.example.superpuperchattbd.app.injector.Injector

class App: Application(){

    override fun onCreate() {
        super.onCreate()
        Injector.init(this)
    }

}
