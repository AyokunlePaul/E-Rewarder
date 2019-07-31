package com.ayokunlepaul.repository.models

data class CustomerEntity (
    val id: Int,
    val firstName: String,
    val lastName: String,
    val emailAddress: String,
    val phoneNumber: String,
    val password: String,
    val dateOfBirth: Int,
    val monthOfBirth: Int,
    val amountSpent: Long
)