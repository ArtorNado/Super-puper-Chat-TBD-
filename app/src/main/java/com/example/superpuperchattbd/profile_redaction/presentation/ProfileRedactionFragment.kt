package com.example.superpuperchattbd.profile_redaction.presentation

import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import com.example.superpuperchattbd.R
import com.example.superpuperchattbd.app.injector.Injector
import com.example.superpuperchattbd.common.base.BaseFragment
import com.example.superpuperchattbd.core_db.model.ProfileEntity
import kotlinx.android.synthetic.main.fragment_profile_redaction.*

class ProfileRedactionFragment : BaseFragment<ProfileRedactionViewModel>() {

    override val layoutId: Int = R.layout.fragment_profile_redaction

    override fun onResume() {
        super.onResume()
        viewModel.getUserData()
    }

    override fun inject() {
        Injector.plusProfileRedactionSubcomponent(this).inject(this)
    }

    override fun initClickListeners() {
        btnEdit.setOnClickListener{
            if (isFieldsEdited()) {
                tvError.visibility = View.GONE
                viewModel.saveUserData(
                    ProfileEntity(
                        0,
                        etName.text.toString(),
                        etAge.text.toString().toInt(),
                        etEmail.text.toString(),
                        etAbout.text.toString(),
                        etStatus.text.toString(),
                        viewModel.imageUrl ?: ""
                    )
                )
            } else {
                tvError.visibility = View.VISIBLE
            }
        }
    }

    private fun isFieldsEdited(): Boolean {
        return !(etName.text.isEmpty() || etAge.text.isEmpty() || etEmail.text.isEmpty() ||
                etAbout.text.isEmpty() || etStatus.text.isEmpty())
    }

    override fun setupViews() {
        initClickListeners()
    }

    override fun subscribe() {
        viewModel.data.observe(viewLifecycleOwner, Observer { userData ->
            Log.e("Update", userData.name)
            etName.setText(userData.name)
            etAge.setText(userData.age.toString())
            etStatus.setText(userData.status)
            etAbout.setText(userData.about)
            etEmail.setText(userData.email)
        })
        viewModel.navigateToProfile.observe(viewLifecycleOwner, Observer { success ->
            if (success) {
                viewModel.navigateToProfile()
            } else {
                tvError.visibility = View.VISIBLE
            }
        })
    }

    override fun onDestroy() {
        Injector.clearProfileRedactionSubcomponent()
        super.onDestroy()
    }

    companion object {
        const val PROFILE_REDACTION_FLAG = false
    }
}
