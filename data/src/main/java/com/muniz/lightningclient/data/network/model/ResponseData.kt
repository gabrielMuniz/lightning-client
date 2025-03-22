package com.muniz.lightningclient.data.network.model

sealed class ResponseData<out T> {
    data class Success<T>(val data: T) : ResponseData<T>()
    data class Error(
        val message: String,
        val throwable: Throwable? = null
    ) : ResponseData<Nothing>()
}