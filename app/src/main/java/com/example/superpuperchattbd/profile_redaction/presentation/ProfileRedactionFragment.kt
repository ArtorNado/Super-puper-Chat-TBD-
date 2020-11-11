package com.example.superpuperchattbd.profile_redaction.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.superpuperchattbd.R
import com.example.superpuperchattbd.app.injector.Injector
import com.example.superpuperchattbd.common.base.BaseFragment

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ProfileRedactionFragment : BaseFragment<ProfileRedactionViewModel>() {

    override val layoutId: Int = R.layout.fragment_profile_redaction

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutId, container, false)
    }

    companion object {
        fun newInstance(param1: String, param2: String) =
            ProfileRedactionFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun inject() {
        Injector.plusProfileRedactionSubcomponent(this).inject(this)
    }

    override fun initClickListeners() {
        TODO("Not yet implemented")
    }

    override fun setupViews() {
        TODO("Not yet implemented")
    }

    override fun subscribe() {
        TODO("Not yet implemented")
    }

    override fun onDestroy() {
        Injector.clearMessengerFeatureSubcomponent()
        super.onDestroy()
    }
}