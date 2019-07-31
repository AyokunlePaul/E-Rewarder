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

    override fun loginCustomerIn(phoneNumber: String, password: String): Single<ResponseModel<Customer>> = Single.just(
        customerCache.getCustomer(
            phoneNumber = phoneNumber,
            password = password
        )
    ).map {
        ResponseModel(
            successful = it.success,
            message = it.message,
            data = it.data?.let { customerEntity -> customerEntityModelMapper.mapToDomain(customerEntity) }
        )
    }
}