package com.example.superpuperchattbd.chat.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.superpuperchattbd.chat.data.interfaces.ChatRepository
import com.example.superpuperchattbd.chat.data.repository.ChatRepositoryImpl
import com.example.superpuperchattbd.chat.di.scope.ChatScope
import com.example.superpuperchattbd.chat.domain.ChatInteractorImpl
import com.example.superpuperchattbd.chat.presentation.ChatViewModel
import com.example.superpuperchattbd.common.di.viewModel.ViewModelKey
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
class ChatFeatureModule {

    @ChatScope
    @Provides
    @IntoMap
    @ViewModelKey(ChatViewModel::class)
    fun provideViewModel(interactor: ChatInteractorImpl): ViewModel {
        return ChatViewModel(interactor)
    }

    @ChatScope
    @Provides
    fun provideViewModelCreator(
        fragment: Fragment,
        viewModelFactory: ViewModelProvider.Factory
    ): ChatViewModel =
        ViewModelProvider(fragment, viewModelFactory).get(ChatViewModel::class.java)

    @ChatScope
    @Provides
    fun provideChatRepository(chatRepository: ChatRepositoryImpl): ChatRepository =
        chatRepository

}
