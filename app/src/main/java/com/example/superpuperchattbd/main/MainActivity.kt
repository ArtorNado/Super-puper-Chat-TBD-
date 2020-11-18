package com.example.superpuperchattbd.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.superpuperchattbd.R
import com.example.superpuperchattbd.app.injector.Injector
import com.example.superpuperchattbd.common.router.NavControllerProvider
import com.google.android.material.bottomnavigation.BottomNavigationView
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var provider: NavControllerProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        Injector.plusMainActivitySubcomponent(this).inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViews()
    }

    override fun onStart() {
        provider.bind(findNavController(R.id.nav_host_fragment))
        super.onStart()
    }

    private fun setupViews(){
        initBottomNavigation()
    }

    private fun initBottomNavigation() {
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        NavigationUI.setupWithNavController(navView, navController)
    }

    override fun onStop() {
        provider.unbind()
        super.onStop()
    }

    override fun onDestroy() {
        Injector.clearMainActivitySubcomponent()
        super.onDestroy()
    }
}
