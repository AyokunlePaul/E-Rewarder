package com.ayokunlepaul.repository.cache

import com.ayokunlepaul.repository.models.BaseRepositoryModel
import com.ayokunlepaul.repository.models.CustomerEntity
import io.reactivex.Completable
import io.reactivex.Single

interface ICustomerCache {

    fun getCustomer(phoneNumber: String, password: String): BaseRepositoryModel<CustomerEntity>
}