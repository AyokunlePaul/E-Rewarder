package com.ayokunlepaul.erewarder.presentation.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ayokunlepaul.erewarder.base.BaseViewModel
import com.ayokunlepaul.erewarder.models.CustomerModel
import com.ayokunlepaul.erewarder.utils.resource.ERewarderResource
import javax.inject.Inject

class LoginFragmentViewModel @Inject constructor(

): BaseViewModel() {

    val customer = MutableLiveData<CustomerModel>()

    private val _logCustomerInState = MutableLiveData<ERewarderResource<CustomerModel>>()
    val logCustomerInState = _logCustomerInState as LiveData<ERewarderResource<CustomerModel>>

    fun loginCustomerIn() {
        
    }
}