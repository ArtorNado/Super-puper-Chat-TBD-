package com.example.superpuperchattbd.theme.presentation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import androidx.appcompat.app.AppCompatDelegate
import com.example.superpuperchattbd.R
import com.example.superpuperchattbd.common.base.BaseFragment
import kotlinx.android.synthetic.main.theme_fragment.*

class ThemeFragment : BaseFragment<ThemeViewModel>(){

    override val layoutId: Int = com.example.superpuperchattbd.R.layout.theme_fragment
    lateinit var animation: Animation
    private val KEY_THEME = "Theme"

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val themeSharedPreferences = this.activity?.getPreferences(Context.MODE_PRIVATE)
        themeSharedPreferences?.getInt(KEY_THEME, 1)?.let { AppCompatDelegate.setDefaultNightMode(it) }
        return inflater.inflate(R.layout.theme_fragment, container, false)
    }

    override fun inject() {
    }

    override fun initClickListeners() {
        val themeSharedPreferences = this.activity?.getPreferences(Context.MODE_PRIVATE)

        btn_theme.setOnClickListener{
            if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                themeSharedPreferences?.edit()?.putInt(KEY_THEME, AppCompatDelegate.MODE_NIGHT_NO)?.apply()
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                themeSharedPreferences?.edit()?.putInt(KEY_THEME, AppCompatDelegate.MODE_NIGHT_YES)?.apply()
            }
        }
    }

    override fun setupViews() {
    }

    override fun subscribe() {
    }
}
