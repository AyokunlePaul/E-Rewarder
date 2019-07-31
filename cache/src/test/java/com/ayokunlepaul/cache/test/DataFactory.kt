package com.ayokunlepaul.cache.test

import com.ayokunlepaul.cache.models.CustomerCacheModel
import java.util.concurrent.ThreadLocalRandom
import kotlin.random.Random

object DataFactory {

    private val customers = listOf(
        CustomerCacheModel (
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
        CustomerCacheModel (
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
        CustomerCacheModel (
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

    fun getCustomer(): CustomerCacheModel = customers[
            Random(System.currentTimeMillis()).nextInt(0, 3)
    ]


}