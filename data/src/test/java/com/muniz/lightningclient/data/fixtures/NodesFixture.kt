package com.muniz.lightningclient.data.fixtures

import com.muniz.lightningclient.data.model.nodes.CityResponse
import com.muniz.lightningclient.data.model.nodes.CountryResponse
import com.muniz.lightningclient.data.model.nodes.NodeResponse

object NodesFixture {

    val nodesResponse = listOf(
        NodeResponse(
            publicKey = "PUBLIC_KEY",
            alias = "ALIAS",
            channels = 123,
            capacity = 1_000L,
            firstSeen = 0,
            updatedAt = 0,
            city = CityResponse(
                de = "", en = "EN", es = "", fr = "", ja = "", ptBR = "PT-BR", ru = "", zhCN = ""
            ),
            country = CountryResponse(
                de = "", en = "EN", es = "", fr = "", ja = "", ptBR = "PT-BR", ru = "", zhCN = ""

            )
        ), NodeResponse(
            publicKey = "",
            alias = "",
            channels = 0,
            capacity = 0,
            firstSeen = 0,
            updatedAt = 0,
            city = CityResponse(
                de = "", en = "EN", es = "", fr = "", ja = "", ptBR = "PT-BR", ru = "", zhCN = ""
            ),
            country = CountryResponse(
                de = "", en = "EN", es = "", fr = "", ja = "", ptBR = "PT-BR", ru = "", zhCN = ""
            )
        )
    )
}