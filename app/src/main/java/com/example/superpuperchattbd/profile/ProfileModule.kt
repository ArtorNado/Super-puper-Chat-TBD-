package com.example.superpuperchattbd.profile

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
class ProfileModule {

    @ProfileScope
    @Provides
    @IntoMap
    @ViewModelKey(ProfileViewModel::class)
    fun provideViewModel(interactor: ProfileInteractorImpl): ViewModel {
        return ProfileViewModel(interactor)
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