package com.ayokunlepaul.erewarder.utils

import androidx.annotation.IdRes
import androidx.navigation.NavDirections

sealed class ERewarderNavigationCommand {
    data class To(val direction: NavDirections): ERewarderNavigationCommand()
    object Back: ERewarderNavigationCommand()
    data class BackTo(@IdRes val destinationId: Int): ERewarderNavigationCommand()
    object BacToRoot: ERewarderNavigationCommand()
}