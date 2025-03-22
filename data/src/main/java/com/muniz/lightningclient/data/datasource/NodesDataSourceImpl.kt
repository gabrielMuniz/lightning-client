package com.muniz.lightningclient.data.datasource

import com.muniz.lightningclient.data.model.nodes.NodeResponse
import com.muniz.lightningclient.data.network.awaitResponse
import com.muniz.lightningclient.data.remote.NodesApi

class NodesDataSourceImpl(private val nodesApi: NodesApi) : NodesDataSource {
    override suspend fun getNodesConnectivity(): List<NodeResponse> {
        return nodesApi.getNodesConnectivity().awaitResponse()
    }
}