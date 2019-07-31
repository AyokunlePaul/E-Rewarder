package com.ayokunlepaul.erewarder.mappers

import com.ayokunlepaul.domain.models.Customer
import com.ayokunlepaul.erewarder.models.CustomerModel
import javax.inject.Inject

class CustomerModelMapper @Inject constructor(

): PresentationModelMapper<Customer, CustomerModel> {

    override fun mapToDomain(presentation: CustomerModel): Customer = Customer(
        id = presentation.id,
        password = presentation.password,
        emailAddress = presentation.emailAddress,
        monthOfBirth = presentation.monthOfBirth,
        dateOfBirth = presentation.dateOfBirth,
        phoneNumber = presentation.phoneNumber,
        lastName = presentation.lastName,
        firstName = presentation.firstName,
        amountSpent = presentation.amountSpent
    )

    override fun mapToPresentation(domain: Customer): CustomerModel = CustomerModel(
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
}