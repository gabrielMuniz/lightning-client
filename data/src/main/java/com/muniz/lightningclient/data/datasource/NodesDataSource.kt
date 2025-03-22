package com.muniz.lightningclient.data.datasource

import com.muniz.lightningclient.data.model.nodes.NodeResponse
interface NodesDataSource {

    suspend fun getNodesConnectivity() : List<NodeResponse>

}