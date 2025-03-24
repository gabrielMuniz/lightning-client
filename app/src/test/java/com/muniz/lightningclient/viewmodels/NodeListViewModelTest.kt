package com.muniz.lightningclient.viewmodels

import com.muniz.lightningclient.domain.model.response.Response
import com.muniz.lightningclient.domain.repositories.NodesRepository
import com.muniz.lightningclient.fixtures.NodesFixture
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class NodesListViewModelTest {

    private lateinit var viewModel: NodesListViewModel
    private val repository: NodesRepository = mockk(relaxed = true)

    @Before
    fun setup() {
        Dispatchers.setMain(StandardTestDispatcher())
        viewModel = NodesListViewModel(repository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `getTopHundredNodes should update state to loading and then to success`() = runTest {
        val mockNodes = List(50) { NodesFixture.nodes.first() }

        coEvery { repository.getNodesConnectivity() } returns flowOf(Response.Success(mockNodes))

        viewModel.getTopHundredNodes()

        advanceUntilIdle()

        assertEquals(mockNodes, viewModel.state.value.allNodes)
        assertEquals(
            mockNodes.take(viewModel.state.value.pageSize),
            viewModel.state.value.visibleNodes
        )
        assertFalse(viewModel.state.value.error)
    }

    @Test
    fun `getTopHundredNodes should update state to loading and then to error`() = runTest {
        coEvery { repository.getNodesConnectivity() } returns flowOf(Response.Error("API Error"))

        viewModel.getTopHundredNodes()

        advanceUntilIdle()

        assertTrue(viewModel.state.value.error)
    }

    @Test
    fun `loadMoreNodes should update visibleNodes when there are more nodes`() = runTest {
        val mockNodes = List(50) { NodesFixture.nodes.first() }
        coEvery { repository.getNodesConnectivity() } returns flowOf(Response.Success(mockNodes))

        viewModel = NodesListViewModel(repository)

        viewModel.run {
            getTopHundredNodes()
            loadMoreNodes()
        }

        advanceUntilIdle()

        assertEquals(40, viewModel.state.value.visibleNodes.size)
    }

    @Test
    fun `loadMoreNodes should not change state when there are no more nodes`() = runTest {
        val mockNodes = List(20) { NodesFixture.nodes.first() }

        coEvery { repository.getNodesConnectivity() } returns flowOf(Response.Success(mockNodes))

        viewModel = NodesListViewModel(repository)

        viewModel.run {
            getTopHundredNodes()
            loadMoreNodes()
        }

        advanceUntilIdle()

        assertEquals(20, viewModel.state.value.visibleNodes.size)
    }
}
