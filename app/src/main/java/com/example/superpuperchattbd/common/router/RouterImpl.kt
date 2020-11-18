package com.example.superpuperchattbd.common.router

import android.os.Bundle
import androidx.core.os.bundleOf
import com.example.superpuperchattbd.R
import com.example.superpuperchattbd.messenger.presentation.MessengerFragment
import javax.inject.Inject

class RouterImpl @Inject constructor(
    private val navControllerProvider: NavControllerProvider
) : Router {

    override fun openChat(dialogId: Int) {
        val args = bundleOf(MessengerFragment.DIALOG_ID to dialogId)
        navigateTo(R.id.action_global_chatFragment, args)
    }

    private fun navigateTo(actionId: Int, bundle: Bundle? = null) {
        navControllerProvider.get()
            ?.navigate(actionId, bundle)
    }

    override fun openFriendsScreen() {
        navigateTo(R.id.action_global_friendsFragment)
    }
}
