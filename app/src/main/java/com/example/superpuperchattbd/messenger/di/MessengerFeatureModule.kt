package com.example.superpuperchattbd.messenger.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.superpuperchattbd.common.di.ViewModelKey
import com.example.superpuperchattbd.messenger.di.scope.MessengerScope
import com.example.superpuperchattbd.messenger.presentation.MessengerViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
class MessengerFeatureModule {

    @MessengerScope
    @Provides
    @IntoMap
    @ViewModelKey(MessengerViewModel::class)
    fun provideMatchListViewModel(): ViewModel {
        return MessengerViewModel()
    }

    @MessengerScope
    @Provides
    fun provideViewModelCreator(
        fragment: Fragment,
        viewModelFactory: ViewModelProvider.Factory
    ): MessengerViewModel =
        ViewModelProvider(fragment, viewModelFactory).get(MessengerViewModel::class.java)

}
