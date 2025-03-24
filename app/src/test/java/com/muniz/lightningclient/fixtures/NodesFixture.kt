package com.muniz.lightningclient.fixtures

import com.muniz.lightningclient.domain.model.City
import com.muniz.lightningclient.domain.model.Country
import com.muniz.lightningclient.domain.model.Node

object NodesFixture {

    val nodes = listOf<Node>(
        Node(
            publicKey = "PUBLIC_KEY",
            alias = "ALIAS",
            channels = 123,
            capacity = 1.000,
            firstSeen = 0,
            updatedAt = 0,
            city = City(
                de = "", en = "EN", es = "", fr = "", ja = "", ptBR = "PT-BR", ru = "", zhCN = ""
            ),
            country = Country(
                de = "", en = "EN", es = "", fr = "", ja = "", ptBR = "PT-BR", ru = "", zhCN = ""

            )
        ), Node(
            publicKey = "",
            alias = "",
            channels = 0,
            capacity = 1.000,
            firstSeen = 0,
            updatedAt = 0,
            city = City(
                de = "", en = "EN", es = "", fr = "", ja = "", ptBR = "PT-BR", ru = "", zhCN = ""
            ),
            country = Country(
                de = "", en = "EN", es = "", fr = "", ja = "", ptBR = "PT-BR", ru = "", zhCN = ""
            )
        )
    )
}