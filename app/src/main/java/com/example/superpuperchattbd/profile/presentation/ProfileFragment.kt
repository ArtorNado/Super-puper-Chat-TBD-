package com.example.superpuperchattbd.profile.presentation

import android.util.Log
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.superpuperchattbd.R
import com.example.superpuperchattbd.app.injector.Injector
import com.example.superpuperchattbd.common.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : BaseFragment<ProfileViewModel>() {

    override val layoutId: Int = R.layout.fragment_profile

    override fun inject() {
        Injector.plusProfileSubcomponent(this).inject(this)
    }

    override fun initClickListeners() {
        btn_edit_profile.setOnClickListener{
            Log.e("init btn listener", "Iniiit")
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
