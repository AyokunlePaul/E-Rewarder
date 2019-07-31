package com.ayokunlepaul.repository.models

data class BaseRepositoryModel<DATA> (
    val data: DATA? = null,
    val success: Boolean,
    val message: String? = null
)