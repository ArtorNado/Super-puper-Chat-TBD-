package com.example.superpuperchattbd.friends_list.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.superpuperchattbd.common.di.viewModel.ViewModelKey
import com.example.superpuperchattbd.common.router.Router
import com.example.superpuperchattbd.friends_list.data.FriendsInteractor
import com.example.superpuperchattbd.friends_list.data.FriendsRepository
import com.example.superpuperchattbd.friends_list.data.FriendsRepositoryImpl
import com.example.superpuperchattbd.friends_list.presentation.FriendsListViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
class FriendsFeatureModule {

    @FriendsScope
    @Provides
    @IntoMap
    @ViewModelKey(FriendsListViewModel::class)
    fun provideViewModel(interactor: FriendsInteractor, router: Router): ViewModel {
        return FriendsListViewModel(interactor, router)
    }

    @FriendsScope
    @Provides
    fun provideViewModelCreator(
        fragment: Fragment,
        viewModelFactory: ViewModelProvider.Factory
    ): FriendsListViewModel =
        ViewModelProvider(fragment, viewModelFactory).get(FriendsListViewModel::class.java)

    @FriendsScope
    @Provides
    fun provideFriendsRepository(friendsRepository: FriendsRepositoryImpl): FriendsRepository =
        friendsRepository
}
