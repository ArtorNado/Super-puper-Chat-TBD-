package com.example.superpuperchattbd.messenger.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.superpuperchattbd.R
import com.example.superpuperchattbd.common.base.presentation.BaseFragment

class MessengerFragment : BaseFragment() {

    private lateinit var viewModel: MessengerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.messenger_fragment, container, false)
    }

    override fun inject() {
        TODO("Not yet implemented")
    }

    override fun initClickListeners() {
        TODO("Not yet implemented")
    }

    override fun setupViews() {
        TODO("Not yet implemented")
    }

}
