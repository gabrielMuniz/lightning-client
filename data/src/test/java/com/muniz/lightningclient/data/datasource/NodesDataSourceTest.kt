package com.muniz.lightningclient.data.datasource

import com.muniz.lightningclient.data.fixtures.NodesFixture
import com.muniz.lightningclient.data.network.awaitResponse
import com.muniz.lightningclient.data.network.model.ResponseData
import com.muniz.lightningclient.data.remote.NodesApi
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class NodesDataSourceTest {

    private lateinit var dataSource: NodesDataSourceImpl
    private val nodesApi: NodesApi = mockk(relaxed = true)

    @Before
    fun setup() {
        dataSource = NodesDataSourceImpl(nodesApi)
    }

    @Test
    fun `getNodesConnectivity should return success when API returns data`() = runTest {
        val mockResponse = NodesFixture.nodesResponse

        coEvery { nodesApi.getNodesConnectivity().awaitResponse() } returns mockResponse

        val result = dataSource.getNodesConnectivity()

        assert(result is ResponseData.Success)
        assertEquals(mockResponse, (result as ResponseData.Success).data)
    }

    @Test
    fun `getNodesConnectivity should return error when API throws exception`() = runTest {
        val errorMessage = "API Failure"
        val exception = Exception(errorMessage)

        coEvery { nodesApi.getNodesConnectivity().awaitResponse() } throws exception

        val result = dataSource.getNodesConnectivity()

        assert(result is ResponseData.Error)
        assertEquals(errorMessage, (result as ResponseData.Error).message)
        assertEquals(exception, result.throwable)
    }
}
