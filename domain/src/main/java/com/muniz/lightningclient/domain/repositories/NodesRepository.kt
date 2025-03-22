package com.muniz.lightningclient.domain.repositories

import com.muniz.lightningclient.domain.model.Node
import kotlinx.coroutines.flow.Flow

interface NodesRepository {

    suspend fun getNodesConnectivity() : Flow<List<Node>>

}