package com.example.superpuperchattbd.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.superpuperchattbd.R
import com.example.superpuperchattbd.app.injector.Injector
import com.example.superpuperchattbd.common.base.BaseFragment

class ProfileFragment : BaseFragment<ProfileViewModel>() {

    override val layoutId: Int = R.layout.fragment_profile

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun inject() {
        Injector.plusProfileSubcomponent(this).inject(this)
    }

    override fun initClickListeners() {

    }

    override fun setupViews() {

    }

    override fun subscribe() {
    }
}