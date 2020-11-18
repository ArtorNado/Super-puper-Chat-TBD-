package com.example.superpuperchattbd.profile.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.superpuperchattbd.R
import com.example.superpuperchattbd.app.injector.Injector
import com.example.superpuperchattbd.common.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : BaseFragment<ProfileViewModel>() {

    override val layoutId: Int = R.layout.fragment_profile

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }


    override fun inject() {
        Injector.plusProfileSubcomponent(this).inject(this)
    }

    override fun initClickListeners() {
        btn_edit_profile.setOnClickListener{
            viewModel.editProfile()
        }
    }

    override fun setupViews() {
    }

    override fun subscribe() {
        viewModel.data.observe(viewLifecycleOwner, Observer {
            Glide.with(this).load(it.imageUrl).into(iv_profile)
        })
    }
}
