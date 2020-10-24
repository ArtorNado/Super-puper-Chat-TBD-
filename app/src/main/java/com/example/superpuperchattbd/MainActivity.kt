package com.example.superpuperchattbd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.superpuperchattbd.app.injector.Injector

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Injector.plusMainActivityFeatureSubcomponent(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //
    }
}
