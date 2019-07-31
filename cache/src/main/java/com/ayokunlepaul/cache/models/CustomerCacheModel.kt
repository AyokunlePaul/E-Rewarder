package com.ayokunlepaul.cache.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CUSTOMER")
data class CustomerCacheModel (
    @PrimaryKey(autoGenerate = true) val id: Int,
    val firstName: String,
    val lastName: String,
    val emailAddress: String,
    val phoneNumber: String,
    val password: String,
    val dateOfBirth: Int,
    val monthOfBirth: Int,
    val amountSpent: Long
)