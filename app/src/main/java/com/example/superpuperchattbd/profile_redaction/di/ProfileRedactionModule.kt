package com.example.superpuperchattbd.profile_redaction.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.superpuperchattbd.common.di.viewModel.ViewModelKey
import com.example.superpuperchattbd.profile_redaction.data.repository.ProfileRedactionRepository
import com.example.superpuperchattbd.profile_redaction.data.repository.ProfileRedactionRepositoryImpl
import com.example.superpuperchattbd.profile_redaction.di.scope.ProfileRedactionScope
import com.example.superpuperchattbd.profile_redaction.domain.ProfileRedactionInteractorImpl
import com.example.superpuperchattbd.profile_redaction.presentation.ProfileRedactionViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
class ProfileRedactionModule {

    @ProfileRedactionScope
    @Provides
    @IntoMap
    @ViewModelKey(ProfileRedactionViewModel::class)
    fun provideViewModel(interactor: ProfileRedactionInteractorImpl): ViewModel {
        return ProfileRedactionViewModel(interactor)
    }

    @ProfileRedactionScope
    @Provides
    fun provideViewModelCreator(
        fragment: Fragment,
        viewModelFactory: ViewModelProvider.Factory
    ): ProfileRedactionViewModel =
        ViewModelProvider(fragment, viewModelFactory).get(ProfileRedactionViewModel::class.java)

    @ProfileRedactionScope
    @Provides
    fun provideMessengerRepository(repository: ProfileRedactionRepositoryImpl): ProfileRedactionRepository =
        repository
}