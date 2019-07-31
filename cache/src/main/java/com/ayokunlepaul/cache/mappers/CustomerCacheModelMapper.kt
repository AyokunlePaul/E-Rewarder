package com.ayokunlepaul.cache.mappers

import com.ayokunlepaul.cache.models.CustomerCacheModel
import com.ayokunlepaul.repository.models.CustomerEntity
import javax.inject.Inject

class CustomerCacheModelMapper @Inject constructor(

): CacheModelMapper<CustomerCacheModel, CustomerEntity> {

    override fun mapToCache(repository: CustomerEntity): CustomerCacheModel = CustomerCacheModel(
        id = repository.id,
        firstName = repository.firstName,
        lastName = repository.lastName,
        phoneNumber = repository.phoneNumber,
        dateOfBirth = repository.dateOfBirth,
        emailAddress = repository.emailAddress,
        monthOfBirth = repository.monthOfBirth,
        password = repository.password,
        amountSpent = repository.amountSpent
    )

    override fun mapToRepository(cache: CustomerCacheModel): CustomerEntity = CustomerEntity(
        id = cache.id,
        firstName = safeString(cache.firstName),
        lastName = safeString(cache.lastName),
        phoneNumber = safeString(cache.phoneNumber),
        dateOfBirth = cache.dateOfBirth,
        monthOfBirth = cache.monthOfBirth,
        emailAddress = safeString(cache.emailAddress),
        password = cache.password,
        amountSpent = cache.amountSpent
    )
}