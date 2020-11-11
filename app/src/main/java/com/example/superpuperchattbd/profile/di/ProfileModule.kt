package com.example.superpuperchattbd.profile.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.superpuperchattbd.common.di.viewModel.ViewModelKey
import com.example.superpuperchattbd.profile.data.ProfileRepository
import com.example.superpuperchattbd.profile.data.ProfileRepositoryImpl
import com.example.superpuperchattbd.profile.di.scope.ProfileScope
import com.example.superpuperchattbd.profile.domain.ProfileInteractorImpl
import com.example.superpuperchattbd.profile.presentation.ProfileViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
class ProfileModule {

    @ProfileScope
    @Provides
    @IntoMap
    @ViewModelKey(ProfileViewModel::class)
    fun provideViewModel(interactor: ProfileInteractorImpl): ViewModel {
        return ProfileViewModel(
            interactor
        )
    }

    @ProfileScope
    @Provides
    fun provideViewModelCreator(
        fragment: Fragment,
        viewModelFactory: ViewModelProvider.Factory
    ): ProfileViewModel =
        ViewModelProvider(fragment, viewModelFactory).get(ProfileViewModel::class.java)

    @ProfileScope
    @Provides
    fun provideMessengerRepository(repository: ProfileRepositoryImpl): ProfileRepository =
        repository
}
