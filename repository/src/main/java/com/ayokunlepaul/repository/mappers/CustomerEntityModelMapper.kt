package com.ayokunlepaul.repository.mappers

import com.ayokunlepaul.domain.models.Customer
import com.ayokunlepaul.repository.models.CustomerEntity
import javax.inject.Inject

class CustomerEntityModelMapper @Inject constructor(

): RepositoryModelMapper<CustomerEntity, Customer> {

    override fun mapToRepository(domain: Customer): CustomerEntity = CustomerEntity(
        id = domain.id,
        password = domain.password,
        emailAddress = domain.emailAddress,
        monthOfBirth = domain.monthOfBirth,
        dateOfBirth = domain.dateOfBirth,
        phoneNumber = domain.phoneNumber,
        lastName = domain.lastName,
        firstName = domain.firstName,
        amountSpent = domain.amountSpent
    )

    override fun mapToDomain(repository: CustomerEntity): Customer = Customer(
        id = repository.id,
        password = repository.password,
        emailAddress = repository.emailAddress,
        monthOfBirth = repository.monthOfBirth,
        dateOfBirth = repository.dateOfBirth,
        phoneNumber = repository.phoneNumber,
        lastName = repository.lastName,
        firstName = repository.firstName,
        amountSpent = repository.amountSpent
    )
}