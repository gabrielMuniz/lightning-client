package com.muniz.lightningclient.domain.model.response

sealed class Response<out T> {
    data class Success<T>(val data: T) : Response<T>()
    data class Error(
        val message: String,
        val throwable: Throwable? = null
    ) : Response<Nothing>()
}