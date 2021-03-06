package com.example.superpuperchattbd.common.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import javax.inject.Inject

abstract class BaseFragment<T : BaseViewModel> : Fragment() {

    @Inject
    protected open lateinit var viewModel: T

    protected abstract val layoutId: Int

    private val observables = mutableListOf<LiveData<*>>()

    protected abstract fun inject()

    protected abstract fun initClickListeners()

    protected abstract fun setupViews()

    protected abstract fun subscribe()

    override fun onAttach(context: Context) {
        inject()
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(layoutId, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        initClickListeners()
        subscribe()
    }

    fun snackBar(text: String) {
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
}
