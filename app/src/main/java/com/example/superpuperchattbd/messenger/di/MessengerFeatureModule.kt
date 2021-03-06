package com.example.superpuperchattbd.messenger.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.superpuperchattbd.common.di.viewModel.ViewModelKey
import com.example.superpuperchattbd.messenger.data.repository.MessengerRepositoryImpl
import com.example.superpuperchattbd.messenger.data.interfaces.MessengerRepository
import com.example.superpuperchattbd.messenger.di.scope.MessengerScope
import com.example.superpuperchattbd.messenger.domain.MessengerInteractor
import com.example.superpuperchattbd.messenger.presentation.MessengerViewModel
import com.example.superpuperchattbd.messenger.router.MessengerRouter
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
class MessengerFeatureModule {

    @MessengerScope
    @Provides
    @IntoMap
    @ViewModelKey(MessengerViewModel::class)
    fun provideMatchListViewModel(interactor: MessengerInteractor, router: MessengerRouter): ViewModel {
        return MessengerViewModel(interactor, router)
    }

    @MessengerScope
    @Provides
    fun provideViewModelCreator(
        fragment: Fragment,
        viewModelFactory: ViewModelProvider.Factory
    ): MessengerViewModel =
        ViewModelProvider(fragment, viewModelFactory).get(MessengerViewModel::class.java)

    @MessengerScope
    @Provides
    fun provideMessengerRepository(messengerRepository: MessengerRepositoryImpl): MessengerRepository =
        messengerRepository

}
