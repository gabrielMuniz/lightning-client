package com.muniz.lightningclient.data.mapper

import com.muniz.lightningclient.data.model.nodes.CityResponse
import com.muniz.lightningclient.data.model.nodes.CountryResponse
import com.muniz.lightningclient.data.model.nodes.NodeResponse
import com.muniz.lightningclient.domain.extensions.convertSatToBTC
import com.muniz.lightningclient.domain.model.City
import com.muniz.lightningclient.domain.model.Country
import com.muniz.lightningclient.domain.model.Node

fun NodeResponse.toNodeEntity() = Node(
    publicKey = publicKey,
    alias = alias,
    channels = channels,
    capacity = capacity.convertSatToBTC().toDouble(),
    firstSeen = firstSeen,
    updatedAt = updatedAt,
    city = city?.toCityEntity(),
    country = country?.toCountryEntity()
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

fun CityResponse.toCityEntity() = City(
    de = de.orEmpty(),
    en = en.orEmpty(),
    es = es.orEmpty(),
    fr = fr.orEmpty(),
    ja = ja.orEmpty(),
    ptBR = ptBR.orEmpty(),
    ru = ru.orEmpty(),
    zhCN = zhCN.orEmpty()
)

