package com.example.superpuperchattbd.friends_list.presentation

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.superpuperchattbd.R
import com.example.superpuperchattbd.app.injector.Injector
import com.example.superpuperchattbd.common.base.BaseFragment
import com.example.superpuperchattbd.friends_list.presentation.rv.FriendsRecyclerAdapter
import kotlinx.android.synthetic.main.fragment_friends_list.*

class FriendsListFragment : BaseFragment<FriendsListViewModel>() {
    override val layoutId = R.layout.fragment_friends_list

    private var adapter: FriendsRecyclerAdapter? = null

    override fun inject() {
        Injector.plusFriendsFeatureSubcomponent(this).inject(this)
    }

    override fun initClickListeners() {
        //
    }

    override fun setupViews() {
        rvFriends.layoutManager = LinearLayoutManager(context)
    }

    override fun subscribe() {
        observe(viewModel.data, Observer { factory ->
            adapter = FriendsRecyclerAdapter { item -> viewModel.friendChosen(item) }
            rvFriends.adapter = adapter
            if (factory != null) {
                adapter!!.submitList(factory)
            }
        })
    }
}
