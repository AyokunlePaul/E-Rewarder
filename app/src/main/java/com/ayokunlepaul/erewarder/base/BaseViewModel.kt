package com.ayokunlepaul.erewarder.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ayokunlepaul.erewarder.utils.ERewarderNavigationCommand

open class BaseViewModel constructor(

) {

    private val _navigationCommand = MutableLiveData<ERewarderNavigationCommand>()
    val navigationCommand = _navigationCommand as LiveData<ERewarderNavigationCommand>

    protected fun navigate(command: ERewarderNavigationCommand) {
        _navigationCommand.postValue(
            command
        )
    }
}