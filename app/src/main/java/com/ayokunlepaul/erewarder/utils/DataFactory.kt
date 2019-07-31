package com.ayokunlepaul.erewarder.utils

import com.ayokunlepaul.erewarder.models.CustomerModel
import java.util.concurrent.ThreadLocalRandom
import kotlin.random.Random

object DataFactory {

    private val customers = listOf(
        CustomerModel (
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
        CustomerModel (
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
        CustomerModel (
            id = ThreadLocalRandom.current().nextInt(1, 1000),
            amountSpent = ThreadLocalRandom.current().nextLong(0, 400000),
            password = "987654",
            firstName = "Erwin",
            lastName = "Schrodinger",
            phoneNumber = "08162337635",
            dateOfBirth = ThreadLocalRandom.current().nextInt(1, 30),
            monthOfBirth = ThreadLocalRandom.current().nextInt(1, 12),
            emailAddress = "erwin@schrodinger.com"
        ),
        CustomerModel (
            id = ThreadLocalRandom.current().nextInt(1, 1000),
            amountSpent = ThreadLocalRandom.current().nextLong(0, 400000),
            password = "123456",
            firstName = "Pauli",
            lastName = "Wolfgang",
            phoneNumber = "09033445566",
            dateOfBirth = ThreadLocalRandom.current().nextInt(1, 30),
            monthOfBirth = ThreadLocalRandom.current().nextInt(1, 12),
            emailAddress = "pauli@wolfgang.com"
        ),
        CustomerModel (
            id = ThreadLocalRandom.current().nextInt(1, 1000),
            amountSpent = ThreadLocalRandom.current().nextLong(0, 400000),
            password = "123456",
            firstName = "Stephen",
            lastName = "Hawking",
            phoneNumber = "09099887762",
            dateOfBirth = ThreadLocalRandom.current().nextInt(1, 30),
            monthOfBirth = ThreadLocalRandom.current().nextInt(1, 12),
            emailAddress = "stephen@hawking.com"
        ),
        CustomerModel (
            id = ThreadLocalRandom.current().nextInt(1, 1000),
            amountSpent = ThreadLocalRandom.current().nextLong(0, 400000),
            password = "123456",
            firstName = "Max",
            lastName = "Planck",
            phoneNumber = "08125364789",
            dateOfBirth = ThreadLocalRandom.current().nextInt(1, 30),
            monthOfBirth = ThreadLocalRandom.current().nextInt(1, 12),
            emailAddress = "max@plack.com"
        ),
        CustomerModel (
            id = ThreadLocalRandom.current().nextInt(1, 1000),
            amountSpent = ThreadLocalRandom.current().nextLong(0, 400000),
            password = "123456",
            firstName = "Marie",
            lastName = "Curie",
            phoneNumber = "08172635467",
            dateOfBirth = ThreadLocalRandom.current().nextInt(1, 30),
            monthOfBirth = ThreadLocalRandom.current().nextInt(1, 12),
            emailAddress = "marie@curie.com"
        )
    )

    fun getCustomer(): CustomerModel = customers[
            Random(System.currentTimeMillis()).nextInt(0, 3)
    ]
}