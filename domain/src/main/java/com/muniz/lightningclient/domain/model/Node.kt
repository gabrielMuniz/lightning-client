package com.muniz.lightningclient.domain.model

data class Node(
    val publicKey: String,
    val alias: String,
    val channels: Int,
    val capacity: Long,
    val firstSeen: Long,
    val updatedAt: Long,
    val city: City?,
    val country: Country?
)