package com.ayokunlepaul.repository.impl

import com.ayokunlepaul.domain.models.ResponseModel
import com.ayokunlepaul.domain.repository.ICustomerRepository
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CustomerRepositoryTest {

    @Mock
    private lateinit var customerRepository: ICustomerRepository

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun testCustomerLogin() {
        Mockito.doReturn(Single.just(
            ResponseModel(
                successful = true,
                data = DataFactory.getCustomer(2)
            )
        )).`when`(customerRepository).loginCustomerIn(
            phoneNumber = "08162337635",
            password = "987654"
        )

        val testObserver = customerRepository.loginCustomerIn(
            phoneNumber = "08162337635",
            password = "987654"
        ).test()

        testObserver.assertValue { it.successful }
    }
}