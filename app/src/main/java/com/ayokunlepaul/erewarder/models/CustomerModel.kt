package com.ayokunlepaul.erewarder.models

data class CustomerModel (
    val id: Int,
    val firstName: String,
    val lastName: String,
    val emailAddress: String,
    var phoneNumber: String,
    var password: String,
    val dateOfBirth: Int,
    val monthOfBirth: Int
)