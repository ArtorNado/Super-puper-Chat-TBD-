package com.example.superpuperchattbd.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.superpuperchattbd.R
import com.example.superpuperchattbd.app.injector.Injector
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Injector.plusMainActivityFeatureSubcomponent(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initBottomNav()
    }

    private fun initBottomNav() {
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        NavigationUI.setupWithNavController(navView, navController)
    }
}
