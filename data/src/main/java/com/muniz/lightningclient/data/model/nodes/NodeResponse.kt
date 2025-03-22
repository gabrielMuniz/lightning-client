package com.muniz.lightningclient.data.model.nodes

data class NodeResponse(
    val publicKey: String,
    val alias: String,
    val channels: Int,
    val capacity: Long,
    val firstSeen: Long,
    val updatedAt: Long,
    val city: String?,
    val country: CountryResponse
)

