package com.ayokunlepaul.domain.repository

import com.ayokunlepaul.domain.models.Customer
import com.ayokunlepaul.domain.models.ResponseModel
import io.reactivex.Single

interface ICustomerRepository {

    fun loginCustomerIn(phoneNumber: String, password: String): Single<ResponseModel<Customer>>
}