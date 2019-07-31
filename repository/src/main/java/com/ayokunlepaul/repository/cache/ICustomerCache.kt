package com.ayokunlepaul.repository.cache

import com.ayokunlepaul.repository.models.CustomerEntity
import io.reactivex.Completable
import io.reactivex.Single

interface ICustomerCache {

    fun saveCustomer(customerEntity: CustomerEntity): Completable

    fun getCustomer(phoneNumber: String, password: String): Single<List<CustomerEntity>>
}