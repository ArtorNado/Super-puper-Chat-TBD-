package com.example.superpuperchattbd.profile_redaction.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.superpuperchattbd.R
import com.example.superpuperchattbd.app.injector.Injector
import com.example.superpuperchattbd.common.base.BaseFragment
import com.example.superpuperchattbd.core_db.model.ProfileEntity
import kotlinx.android.synthetic.main.fragment_profile_redaction.*

class ProfileRedactionFragment : BaseFragment<ProfileRedactionViewModel>() {

    override val layoutId: Int = R.layout.fragment_profile_redaction

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(layoutId, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    override fun onResume() {
        super.onResume()
        subscribe()
        viewModel.getUserData()
    }

    override fun inject() {
        Injector.plusProfileRedactionSubcomponent(this).inject(this)
    }

    override fun initClickListeners() {
        btnEdit.setOnClickListener{
            if (isFieldsEdited()) {
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
            }
        }
    }

    private fun isFieldsEdited(): Boolean {
        return true
    }

    override fun setupViews() {
        initClickListeners()
    }

    override fun subscribe() {
        viewModel.data.observe(viewLifecycleOwner, Observer { userData ->
            etName.setText(userData.name)
            etAge.setText(userData.age)
            etStatus.setText(userData.status)
            etAbout.setText(userData.about)
            etEmail.setText(userData.email)
        })
    }

    override fun onDestroy() {
        Injector.clearProfileRedactionSubcomponent()
        super.onDestroy()
    }
}