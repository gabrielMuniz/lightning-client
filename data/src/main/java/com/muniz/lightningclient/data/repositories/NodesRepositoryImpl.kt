package com.muniz.lightningclient.data.repositories

import com.muniz.lightningclient.data.datasource.NodesDataSource
import com.muniz.lightningclient.data.mapper.toNodeEntity
import com.muniz.lightningclient.data.network.model.ResponseData
import com.muniz.lightningclient.domain.model.Node
import com.muniz.lightningclient.domain.model.response.Response
import com.muniz.lightningclient.domain.repositories.NodesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class NodesRepositoryImpl(private val nodesDataSource: NodesDataSource) : NodesRepository {
    override suspend fun getNodesConnectivity(): Flow<Response<List<Node>>> = flow {
        emit(
            when (val result = nodesDataSource.getNodesConnectivity()) {
                is ResponseData.Success -> {
                    Response.Success(result.data.map { it.toNodeEntity() })
                }

                is ResponseData.Error -> {
                    Response.Error(result.message, result.throwable)
                }
            }
        )
    }
}