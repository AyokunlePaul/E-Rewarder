package com.ayokunlepaul.erewarder.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CustomerModel (
    val id: Int,
    val firstName: String,
    val lastName: String,
    val emailAddress: String,
    var phoneNumber: String,
    var password: String,
    val dateOfBirth: Int,
    val monthOfBirth: Int,
    val amountSpent: Long
): Parcelable {
    constructor(): this(0, "", "", "", "", "", 0, 0, 0)

    val voucherValidity: Int get() {
        return when (amountSpent) {
            in 0 until 1_000 -> 0
            in 1_000 until 5_000 -> 1
            in 5_000 until 10_000 -> 5
            else -> 10
        }
    }
    val getVoucherAmount: Int get() {
        return when (amountSpent) {
            in 0 until 1_000 -> 0
            in 1_000 until 5_000 -> 100
            in 5_000 until 1_0000 -> 500
            else -> 1_000
        }
    }
}