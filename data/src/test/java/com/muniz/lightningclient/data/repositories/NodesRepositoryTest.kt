package com.muniz.lightningclient.data.repositories

import com.muniz.lightningclient.data.datasource.NodesDataSource
import com.muniz.lightningclient.data.fixtures.NodesFixture
import com.muniz.lightningclient.data.mapper.toNodeEntity
import com.muniz.lightningclient.data.network.model.ResponseData
import com.muniz.lightningclient.domain.model.response.Response
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalCoroutinesApi::class)
class NodesRepositoryTest {

    private lateinit var repository: NodesRepositoryImpl
    private val nodesDataSource: NodesDataSource = mockk(relaxed = true)

    @Before
    fun setup() {
        repository = NodesRepositoryImpl(nodesDataSource)
    }

    @Test
    fun `getNodesConnectivity should return success when data source returns success`() = runTest {
        val mockNodes = NodesFixture.nodesResponse
        coEvery {
            nodesDataSource.getNodesConnectivity()
        } returns ResponseData.Success(
            mockNodes
        )

        val result = repository.getNodesConnectivity().first()

        assert(result is Response.Success)
        assertEquals(mockNodes.map { it.toNodeEntity() }, (result as Response.Success).data)
    }

    @Test
    fun `getNodesConnectivity should return error when data source returns error`() = runTest {
        val errorMessage = "API Error"
        val exception = Exception("Error")

        coEvery { nodesDataSource.getNodesConnectivity() } returns ResponseData.Error(
            errorMessage, exception
        )

        val result = repository.getNodesConnectivity().first()

        assert(result is Response.Error)
        assertEquals(errorMessage, (result as Response.Error).message)
        assertEquals(exception, result.throwable)
    }
}
