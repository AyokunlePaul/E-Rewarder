package com.ayokunlepaul.erewarder.presentation.login

import android.text.TextUtils
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ayokunlepaul.domain.interactors.AuthenticateUser
import com.ayokunlepaul.erewarder.base.BaseViewModel
import com.ayokunlepaul.erewarder.mappers.CustomerModelMapper
import com.ayokunlepaul.erewarder.models.CustomerModel
import com.ayokunlepaul.erewarder.utils.resource.ERewarderResource
import javax.inject.Inject

class LoginFragmentViewModel @Inject constructor(
    private val authenticateUser: AuthenticateUser,
    private val customerModelMapper: CustomerModelMapper
): BaseViewModel() {

    var phoneNumber: String = ""
    var password: String = ""

    private val _logCustomerInState = MutableLiveData<ERewarderResource<CustomerModel>>()
    val logCustomerInState = _logCustomerInState as LiveData<ERewarderResource<CustomerModel>>

    fun loginCustomerIn() {
        if (TextUtils.isEmpty(phoneNumber)) {
            _logCustomerInState.postValue(
                ERewarderResource.failed(
                    "Phone number is empty"
                )
            )
            return
        }

        if (!Patterns.PHONE.matcher(phoneNumber).matches()) {
            _logCustomerInState.postValue(
                ERewarderResource.failed(
                    "Invalid phone number input"
                )
            )
            return
        }

        if (TextUtils.isEmpty(password)) {
            _logCustomerInState.postValue(
                ERewarderResource.failed(
                    "Password field is empty"
                )
            )
            return
        }

        authenticateUser.executeUseCaseAndPerformAction(AuthenticateUser.AuthenticationParam(
            phoneNumber = phoneNumber,
            password = password
        ), {
            _logCustomerInState.postValue(
                if (it.successful) ERewarderResource.success(
                    customerModelMapper.mapToPresentation(it.data!!)
                ) else ERewarderResource.failed(
                    "Customer does not exist"
                )
            )
        }) {
            _logCustomerInState.postValue(
                ERewarderResource.failed(
                    it.localizedMessage
                )
            )
        }
    }
}