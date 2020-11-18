package com.example.superpuperchattbd.common.router

import com.example.superpuperchattbd.messenger.router.MessengerRouter
import com.example.superpuperchattbd.profile.router.ProfileRouter
import com.example.superpuperchattbd.profile_redaction.router.ProfileRedactionRouter

interface Router : MessengerRouter, ProfileRedactionRouter, ProfileRouter
