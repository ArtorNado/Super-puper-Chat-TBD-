package com.example.superpuperchattbd.theme.presentation

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import android.view.animation.LinearInterpolator
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.AppCompatImageView
import com.example.superpuperchattbd.R
import com.example.superpuperchattbd.common.base.BaseFragment
import kotlinx.android.synthetic.main.theme_fragment.*

class ThemeFragment : BaseFragment<ThemeViewModel>(){

    override val layoutId: Int = com.example.superpuperchattbd.R.layout.theme_fragment
    lateinit var star: ImageView
    private val KEY_THEME = "Theme"

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.theme_fragment, container, false)
        star = view.findViewById(R.id.star)
        val themeSharedPreferences = this.activity?.getPreferences(Context.MODE_PRIVATE)
        themeSharedPreferences?.getInt(KEY_THEME, 1)?.let { AppCompatDelegate.setDefaultNightMode(it) }
        return view
    }

    override fun inject() {
    }

    override fun initClickListeners() {

        val themeSharedPreferences = this.activity?.getPreferences(Context.MODE_PRIVATE)

        btn_theme.setOnClickListener{
            for(i in 1..15){
                shower()
            }
            Handler().postDelayed({


            if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                themeSharedPreferences?.edit()?.putInt(KEY_THEME, AppCompatDelegate.MODE_NIGHT_NO)?.apply()

            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                themeSharedPreferences?.edit()?.putInt(KEY_THEME, AppCompatDelegate.MODE_NIGHT_YES)?.apply()
            }
            }, 2000)

        }
    }

    private fun shower() {
        val container = star.parent as ViewGroup
        val containerW = container.width
        val containerH = container.height
        var starW: Float = star.width.toFloat()
        var starH: Float = star.height.toFloat()

        val newStar = AppCompatImageView(this.requireContext())
        newStar.setImageResource(R.drawable.ic_star)
        newStar.layoutParams = FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.WRAP_CONTENT,
            FrameLayout.LayoutParams.WRAP_CONTENT)
        container.addView(newStar)

        newStar.scaleX = Math.random().toFloat() * 1.5f + .1f
        newStar.scaleY = newStar.scaleX
        starW *= newStar.scaleX
        starH *= newStar.scaleY

        newStar.translationX = Math.random().toFloat() *
                containerW - starW / 2

        val mover = ObjectAnimator.ofFloat(newStar, View.TRANSLATION_Y,
            -starH, containerH + starH)
        mover.interpolator = AccelerateInterpolator(1f)
        val rotator = ObjectAnimator.ofFloat(newStar, View.ROTATION,
            (Math.random() * 1080).toFloat())
        rotator.interpolator = LinearInterpolator()

        val set = AnimatorSet()
        set.playTogether(mover, rotator)
        set.duration = (Math.random() * 1500 + 500).toLong()

        set.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator?) {
                container.removeView(newStar)

            }
        })
        set.start()
    }

    override fun setupViews() {
    }

    override fun subscribe() {
    }
}
