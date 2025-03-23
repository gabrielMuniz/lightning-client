package com.muniz.lightningclient.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.muniz.lightningclient.ui.components.FullScreenErrorComponent
import com.muniz.lightningclient.ui.components.LoadingIndicatorComponent
import com.muniz.lightningclient.ui.screens.screencomponents.NodeList
import com.muniz.lightningclient.viewmodels.NodesListViewModel
import org.koin.androidx.compose.koinViewModel

/*
    Suppress deprecation because the official
    implementation of pull to refresh have issues
 */
@Suppress("DEPRECATION")
@Composable
fun NodeListScreen() {
    val viewModel: NodesListViewModel = koinViewModel()
    val state by viewModel.state.collectAsStateWithLifecycle()
    val isLoaded = rememberSaveable { mutableStateOf(false) }
    val isRefreshing = rememberSaveable { mutableStateOf(false) }
    val snackBarHostState = remember { SnackbarHostState() }

    fun refreshData() {
        isRefreshing.value = true
        viewModel.getTopHundredNodes()
        isRefreshing.value = false
    }

    LaunchedEffect(Unit) {
        if (!isLoaded.value) {
            viewModel.getTopHundredNodes()
            isLoaded.value = true
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        snackbarHost = { SnackbarHost(hostState = snackBarHostState) }) { innerPadding ->
        SwipeRefresh(
            state = rememberSwipeRefreshState(isRefreshing.value),
            onRefresh = { refreshData() }
        ) {
            when {
                state.isLoading -> {
                    LoadingIndicatorComponent()
                }

                state.error -> {
                    FullScreenErrorComponent(onRetry = { viewModel.getTopHundredNodes() })
                }

                else -> {
                    NodeList(
                        state = state,
                        loadMoreNodes = { viewModel.loadMoreNodes() },
                        paddingValues = innerPadding,
                        snackBarHostState = snackBarHostState
                    )
                }
            }
        }
    }
}