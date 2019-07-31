package com.ayokunlepaul.domain.interactors

import com.ayokunlepaul.domain.models.ResponseModel
import com.ayokunlepaul.domain.repository.ICustomerRepository
import com.ayokunlepaul.domain.utils.RxExecutionThread
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class AuthenticateUserTest {

    @Mock
    lateinit var executionThread: RxExecutionThread

    @Mock
    lateinit var customerRepository: ICustomerRepository

    private lateinit var authenticateUser: AuthenticateUser

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        authenticateUser = AuthenticateUser(executionThread, customerRepository)
    }

    @Test
    fun testUserAuthentication() {
        Mockito.doReturn(Single.just(ResponseModel(successful = true, data = DataFactory.getCustomer(1)))).`when`(customerRepository).loginCustomerIn(
            phoneNumber = "07089735263",
            password = "244466666"
        )
        val testObserver = customerRepository.loginCustomerIn(
            phoneNumber = "07089735263",
            password = "244466666"
        ).test()

        testObserver.assertValue {
            it.data == DataFactory.getCustomer(1)
        }
    }
}