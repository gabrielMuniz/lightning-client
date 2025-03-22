package com.muniz.lightningclient.data.mapper

import com.muniz.lightningclient.data.model.nodes.CountryResponse
import com.muniz.lightningclient.data.model.nodes.NodeResponse
import com.muniz.lightningclient.domain.nodes.Country
import com.muniz.lightningclient.domain.nodes.Node

fun NodeResponse.toNodeEntity() = Node(
    publicKey = publicKey,
    alias = alias,
    channels = channels,
    capacity = capacity,
    firstSeen = firstSeen,
    updatedAt = updatedAt,
    city = city,
    countryResponse = country.toCountryEntity()
)

fun CountryResponse.toCountryEntity() = Country(
    de = de.orEmpty(),
    en = en.orEmpty(),
    es = es.orEmpty(),
    fr = fr.orEmpty(),
    ja = ja.orEmpty(),
    ptBR = ptBR.orEmpty(),
    ru = ru.orEmpty(),
    zhCN = zhCN.orEmpty()
)