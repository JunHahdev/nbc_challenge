package com.example.nbc_challenge.domain.entity

sealed class Result<out T> {
    data object Loading : Result<Nothing>()
    data class Success<T>(val value: T) : Result<T>()
    data class Error(val message: String, val cause: Throwable? = null) : Result<Nothing>()
}