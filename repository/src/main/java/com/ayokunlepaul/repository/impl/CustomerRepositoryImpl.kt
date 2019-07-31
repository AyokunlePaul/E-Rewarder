package com.ayokunlepaul.repository.impl

import com.ayokunlepaul.domain.models.Customer
import com.ayokunlepaul.domain.models.ResponseModel
import com.ayokunlepaul.domain.repository.ICustomerRepository
import com.ayokunlepaul.repository.cache.ICustomerCache
import com.ayokunlepaul.repository.mappers.CustomerEntityModelMapper
import io.reactivex.Single
import javax.inject.Inject

class CustomerRepositoryImpl @Inject constructor(
    private val customerCache: ICustomerCache,
    private val customerEntityModelMapper: CustomerEntityModelMapper
): ICustomerRepository {

    override fun loginCustomerIn(phoneNumber: String, password: String): Single<ResponseModel<Customer>> = customerCache.getCustomer(
        phoneNumber = phoneNumber,
        password = password
    ).map {
        if (it.isEmpty()) ResponseModel(
            successful = false,
            message = "User doesn't exist"
        ) else ResponseModel(
            successful = true,
            data = customerEntityModelMapper.mapToDomain(it[0])
        )
    }
}