package com.ayokunlepaul.cache.utils

import com.ayokunlepaul.cache.models.CustomerCacheModel
import java.util.concurrent.ThreadLocalRandom
import kotlin.random.Random

object DataFactory {

    private val customers = listOf(
        CustomerCacheModel (
            id = ThreadLocalRandom.current().nextInt(1, 1_000),
            amountSpent = ThreadLocalRandom.current().nextLong(8_000, 10_000),
            password = "123456",
            firstName = "Albert",
            lastName = "Einstein",
            phoneNumber = "09025362537",
            dateOfBirth = 1,
            monthOfBirth = 8,
            emailAddress = "albert@einstein.com"
        ),
        CustomerCacheModel (
            id = ThreadLocalRandom.current().nextInt(1, 1_000),
            amountSpent = ThreadLocalRandom.current().nextLong(5_000, 10_000),
            password = "244466666",
            firstName = "Isaac",
            lastName = "Newton",
            phoneNumber = "07089735263",
            dateOfBirth = 2,
            monthOfBirth = 8,
            emailAddress = "isaac@newton.eu"
        ),
        CustomerCacheModel (
            id = ThreadLocalRandom.current().nextInt(1, 1000),
            amountSpent = ThreadLocalRandom.current().nextLong(10, 1_000),
            password = "987654",
            firstName = "Erwin",
            lastName = "Schrodinger",
            phoneNumber = "08162337635",
            dateOfBirth = 3,
            monthOfBirth = 8,
            emailAddress = "erwin@schrodinger.com"
        ),
        CustomerCacheModel (
            id = ThreadLocalRandom.current().nextInt(1, 1000),
            amountSpent = ThreadLocalRandom.current().nextLong(0, 8_000),
            password = "123456",
            firstName = "Pauli",
            lastName = "Wolfgang",
            phoneNumber = "09033445566",
            dateOfBirth = 4,
            monthOfBirth = 8,
            emailAddress = "pauli@wolfgang.com"
        ),
        CustomerCacheModel (
            id = ThreadLocalRandom.current().nextInt(1, 1000),
            amountSpent = ThreadLocalRandom.current().nextLong(1_000, 5_000),
            password = "123456",
            firstName = "Stephen",
            lastName = "Hawking",
            phoneNumber = "09099887762",
            dateOfBirth = 5,
            monthOfBirth = 8,
            emailAddress = "stephen@hawking.com"
        ),
        CustomerCacheModel (
            id = ThreadLocalRandom.current().nextInt(1, 1000),
            amountSpent = ThreadLocalRandom.current().nextLong(100, 1_000),
            password = "123456",
            firstName = "Max",
            lastName = "Planck",
            phoneNumber = "08125364789",
            dateOfBirth = 6,
            monthOfBirth = 8,
            emailAddress = "max@plack.com"
        ),
        CustomerCacheModel (
            id = ThreadLocalRandom.current().nextInt(1, 500),
            amountSpent = ThreadLocalRandom.current().nextLong(0, 2_000),
            password = "123456",
            firstName = "Marie",
            lastName = "Curie",
            phoneNumber = "08172635467",
            dateOfBirth = 7,
            monthOfBirth = 8,
            emailAddress = "marie@curie.com"
        )
    )

    fun getCustomer(): CustomerCacheModel = customers[
            Random(System.currentTimeMillis()).nextInt(0, 7)
    ]

    fun getCustomer(phoneNumber: String, password: String) = customers.find { it.phoneNumber == phoneNumber && it.password == password }
}