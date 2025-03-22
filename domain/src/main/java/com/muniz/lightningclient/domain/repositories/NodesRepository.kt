package com.muniz.lightningclient.domain.repositories

import com.muniz.lightningclient.domain.model.Node
import com.muniz.lightningclient.domain.model.response.Response
import kotlinx.coroutines.flow.Flow

interface NodesRepository {

    suspend fun getNodesConnectivity() : Flow<Response<List<Node>>>

}