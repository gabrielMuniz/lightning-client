package com.muniz.lightningclient.domain.model

data class Node(
    val publicKey: String,
    val alias: String,
    val channels: Int,
    val capacity: Double,
    val firstSeen: Long,
    val updatedAt: Long,
    val city: City?,
    val country: Country?
)