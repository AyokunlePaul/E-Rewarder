package com.ayokunlepaul.domain.interactors

import com.ayokunlepaul.domain.models.Customer
import com.ayokunlepaul.domain.models.ResponseModel
import com.ayokunlepaul.domain.repository.ICustomerRepository
import com.ayokunlepaul.domain.utils.RxExecutionThread
import io.reactivex.Single
import javax.inject.Inject

class AuthenticateUser @Inject constructor(
    executionThread: RxExecutionThread,
    private val customerRepository: ICustomerRepository
): SingleUseCase<AuthenticateUser.AuthenticationParam, ResponseModel<Customer>>(executionThread) {

    override fun buildUseCaseObservable(param: AuthenticationParam?): Single<ResponseModel<Customer>> = param?.let {
        customerRepository.loginCustomerIn(
            password = it.password,
            phoneNumber = it.phoneNumber
        )
    } ?: throw IllegalArgumentException("Invalid authentication argument")

    data class AuthenticationParam (
        val phoneNumber: String,
        val password: String
    )
}