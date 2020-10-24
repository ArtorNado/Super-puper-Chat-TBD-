package com.example.superpuperchattbd.common.base.presentation

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import javax.inject.Inject

abstract class BaseFragment: Fragment() {

    private val observables = mutableListOf<LiveData<*>>()

    protected abstract fun inject()

    protected abstract fun initClickListeners()

    protected abstract fun setupViews()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        inject()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
/*
        subscribe(viewModel)
*/
        initClickListeners()
    }

    fun snackBar(text: String){
        Snackbar.make(
            activity!!.findViewById(android.R.id.content),
            text,
            Snackbar.LENGTH_SHORT
        ).show()
    }

    override fun onDestroyView() {
        observables.forEach { it.removeObservers(this) }
        super.onDestroyView()
    }

    @Suppress("unchecked_cast")
    protected fun <V : Any?> observe(source: LiveData<V>, observer: Observer<V>) {
        source.observe(viewLifecycleOwner, observer as Observer<in Any?>)
        observables.add(source)
    }

/*
    abstract fun subscribe(viewModel: T)
*/
}
