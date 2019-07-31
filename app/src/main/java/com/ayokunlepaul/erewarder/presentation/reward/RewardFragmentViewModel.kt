package com.ayokunlepaul.erewarder.presentation.reward

import androidx.lifecycle.MutableLiveData
import com.ayokunlepaul.erewarder.base.BaseViewModel
import com.ayokunlepaul.erewarder.models.CustomerModel
import javax.inject.Inject

class RewardFragmentViewModel @Inject constructor(

): BaseViewModel() {

    val customer = MutableLiveData<CustomerModel>().apply { value = CustomerModel() }
}