package com.ayokunlepaul.repository.impl

import com.ayokunlepaul.repository.models.CustomerEntity
import java.util.concurrent.ThreadLocalRandom
import kotlin.random.Random

object DataFactory {

    private val customers = listOf(
        CustomerEntity (
            id = ThreadLocalRandom.current().nextInt(1, 1000),
            amountSpent = ThreadLocalRandom.current().nextLong(0, 400000),
            password = "123456",
            firstName = "Albert",
            lastName = "Einstein",
            phoneNumber = "09025362537",
            dateOfBirth = ThreadLocalRandom.current().nextInt(1, 30),
            monthOfBirth = ThreadLocalRandom.current().nextInt(1, 12),
            emailAddress = "albert@einstein.com"
        ),
        CustomerEntity (
            id = ThreadLocalRandom.current().nextInt(1, 1000),
            amountSpent = ThreadLocalRandom.current().nextLong(0, 400000),
            password = "244466666",
            firstName = "Isaac",
            lastName = "Newton",
            phoneNumber = "07089735263",
            dateOfBirth = ThreadLocalRandom.current().nextInt(1, 30),
            monthOfBirth = ThreadLocalRandom.current().nextInt(1, 12),
            emailAddress = "isaac@newton.eu"
        ),
        CustomerEntity (
            id = ThreadLocalRandom.current().nextInt(1, 1000),
            amountSpent = ThreadLocalRandom.current().nextLong(0, 400000),
            password = "987654",
            firstName = "Erwin",
            lastName = "Schrodinger",
            phoneNumber = "08162337635",
            dateOfBirth = ThreadLocalRandom.current().nextInt(1, 30),
            monthOfBirth = ThreadLocalRandom.current().nextInt(1, 12),
            emailAddress = "erwin@schrodinger.com"
        )
    )

    fun getCustomer(): CustomerEntity = customers[
            Random(System.currentTimeMillis()).nextInt(0, 3)
    ]
    fun getCustomer(index: Int): CustomerEntity = customers[index]
}