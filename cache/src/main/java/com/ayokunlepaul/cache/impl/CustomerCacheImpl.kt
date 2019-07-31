package com.ayokunlepaul.cache.impl

import com.ayokunlepaul.cache.mappers.CustomerCacheModelMapper
import com.ayokunlepaul.cache.room.daos.CustomerDao
import com.ayokunlepaul.cache.utils.DataFactory
import com.ayokunlepaul.repository.cache.ICustomerCache
import com.ayokunlepaul.repository.models.BaseRepositoryModel
import com.ayokunlepaul.repository.models.CustomerEntity
import javax.inject.Inject

class CustomerCacheImpl @Inject constructor(
    private val customerCacheModelMapper: CustomerCacheModelMapper
): ICustomerCache {

    override fun getCustomer(phoneNumber: String, password: String): BaseRepositoryModel<CustomerEntity> {
        return DataFactory.getCustomer(phoneNumber, password)?.let {
            BaseRepositoryModel(success = true, data = customerCacheModelMapper.mapToRepository(it))
        } ?: BaseRepositoryModel(success = false, message = "User doesn't exist")
    }
}