package com.example.superpuperchattbd.common.router

import android.os.Bundle
import android.util.Log
import androidx.core.os.bundleOf
import com.example.superpuperchattbd.R
import com.example.superpuperchattbd.chat.presentation.ChatFragment
import com.example.superpuperchattbd.messenger.presentation.MessengerFragment
import javax.inject.Inject

class RouterImpl @Inject constructor(
    private val navControllerProvider: NavControllerProvider
) : Router {

    override fun openChat(dialogId: Int) {
        val args = bundleOf(MessengerFragment.DIALOG_ID to dialogId)
        navigateTo(R.id.action_global_chatFragment, args)
    }

    override fun backToProfile() {
        navigateTo(R.id.action_global_profileFragment)
    }
    override fun editProfile() {
        Log.d("gogogo", "gogogog")
        navigateTo(R.id.action_navigation_profile_to_profileRedactionFragment)
    }

    override fun openProfile(id: Int) {
        val args = bundleOf(ChatFragment.PROFILE_ID to id)
        navigateTo(R.id.action_chat_to_profile, args)
    }

    private fun navigateTo(actionId: Int, bundle: Bundle? = null) {
        navControllerProvider.get()
            ?.navigate(actionId, bundle)
    }

    override fun openFriendsScreen() {
        navigateTo(R.id.action_global_friendsFragment)
    }
}
