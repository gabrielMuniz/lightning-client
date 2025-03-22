package com.muniz.lightningclient.data.datasource

import com.muniz.lightningclient.data.model.nodes.NodeResponse
import com.muniz.lightningclient.data.network.model.ResponseData

interface NodesDataSource {

    suspend fun getNodesConnectivity(): ResponseData<List<NodeResponse>>

}