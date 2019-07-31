package com.ayokunlepaul.cache.impl

import com.ayokunlepaul.cache.mappers.CustomerCacheModelMapper
import com.ayokunlepaul.cache.room.daos.CustomerDao
import com.ayokunlepaul.repository.cache.ICustomerCache
import com.ayokunlepaul.repository.models.CustomerEntity
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class CustomerCacheImpl @Inject constructor(
    private val customerDao: CustomerDao,
    private val customerCacheModelMapper: CustomerCacheModelMapper
): ICustomerCache {

    override fun saveCustomer(customerEntity: CustomerEntity): Completable = Completable.fromAction {
        customerDao.saveCustomer(
            customerCacheModelMapper.mapToCache(customerEntity)
        )
    }

    override fun getCustomer(phoneNumber: String, password: String): Single<List<CustomerEntity>> = Single.just(
        customerDao.getCustomer(
            phoneNumber = phoneNumber,
            password = password
        ).map { customerCacheModelMapper.mapToRepository(it) }
    )
}