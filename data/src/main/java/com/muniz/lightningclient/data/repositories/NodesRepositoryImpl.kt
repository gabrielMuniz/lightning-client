package com.muniz.lightningclient.data.repositories

import com.muniz.lightningclient.data.datasource.NodesDataSource
import com.muniz.lightningclient.data.mapper.toNodeEntity
import com.muniz.lightningclient.domain.model.Node
import com.muniz.lightningclient.domain.repositories.NodesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class NodesRepositoryImpl(private val nodesDataSource: NodesDataSource) : NodesRepository {
    override suspend fun getNodesConnectivity(): Flow<List<Node>> = flow {
        try {
            emit(nodesDataSource.getNodesConnectivity().map { response ->
                response.toNodeEntity()
            })
        } catch (ex: Exception) {
            throw Exception("Erro ao buscar dados da API: ${ex.message}")
        }
    }
}