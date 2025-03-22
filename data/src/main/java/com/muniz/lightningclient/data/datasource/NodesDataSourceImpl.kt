package com.muniz.lightningclient.data.datasource

import com.muniz.lightningclient.data.model.nodes.NodeResponse
import com.muniz.lightningclient.data.network.awaitResponse
import com.muniz.lightningclient.data.network.model.ResponseData
import com.muniz.lightningclient.data.remote.NodesApi

class NodesDataSourceImpl(private val nodesApi: NodesApi) : NodesDataSource {
    override suspend fun getNodesConnectivity(): ResponseData<List<NodeResponse>> {
        return try {
            ResponseData.Success(nodesApi.getNodesConnectivity().awaitResponse())
        } catch (exception: Exception) {
            ResponseData.Error(exception.message.orEmpty(), exception)
        }
    }
}