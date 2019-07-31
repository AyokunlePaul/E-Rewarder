package com.ayokunlepaul.domain.models

data class ResponseModel <D> (
    val successful: Boolean,
    val data: D? = null,
    val message: String? = null
)