package com.example.superpuperchattbd.profile.presentation

import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.superpuperchattbd.R
import com.example.superpuperchattbd.app.injector.Injector
import com.example.superpuperchattbd.chat.presentation.ChatFragment
import com.example.superpuperchattbd.common.base.BaseFragment
import com.example.superpuperchattbd.profile_redaction.presentation.ProfileRedactionFragment
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : BaseFragment<ProfileViewModel>() {

    override val layoutId: Int = R.layout.fragment_profile

    private var userId: Int = 0

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
        userId = arguments?.getInt(ChatFragment.PROFILE_ID) ?: 0
        btn_edit_profile.visibility = if (userId == 0) View.VISIBLE else View.INVISIBLE
        if(!ProfileRedactionFragment.PROFILE_REDACTION_FLAG) btn_edit_profile.visibility = View.INVISIBLE
    }

    override fun subscribe() {
        //viewModel.getUser(userId)
        viewModel.data.observe(viewLifecycleOwner, Observer {
            Log.e("Updaaate", it.name)
            tv_name_profile.text = it.name
            tv_status_profile.text = "Status: " + it.status
            tv_about_profile.text = "About: " + it.about
            tv_email_profile.text = "E-mail " + it.email
            tv_age_profile.text = it.age.toString() + " y.o"
            Glide.with(this).load(it.imageUrl).into(iv_profile)
        })
    }

    override fun onResume() {
        super.onResume()
        viewModel.refresh(userId)
    }

    companion object {
        const val PROFILE_FLAG = true
    }
}
