package com.ayokunlepaul.repository.cache

import com.ayokunlepaul.repository.models.CustomerEntity
import io.reactivex.Completable

interface ICustomerCache {

    fun saveCustomer(customerEntity: CustomerEntity): Completable

    fun getCustomer(phoneNumber: String, password: String): CustomerEntity?
}