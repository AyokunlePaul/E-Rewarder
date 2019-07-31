package com.ayokunlepaul.domain.models

data class Customer (
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