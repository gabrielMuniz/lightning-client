package com.muniz.lightningclient.data.mapper

import com.muniz.lightningclient.data.network.model.ResponseData
import com.muniz.lightningclient.domain.model.response.Response

fun <T> ResponseData<T>.toDomain(): Response<T> {
    return when (this) {
        is ResponseData.Success -> Response.Success(this.data)
        is ResponseData.Error -> Response.Error(this.message, this.throwable)
    }
}
