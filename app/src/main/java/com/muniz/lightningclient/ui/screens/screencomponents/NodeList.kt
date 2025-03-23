package com.muniz.lightningclient.ui.screens.screencomponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.muniz.lightningclient.R
import com.muniz.lightningclient.viewmodels.NodesListState


@Composable
fun NodeList(
    state: NodesListState,
    paddingValues: PaddingValues,
    loadMoreNodes: () -> Unit,
    snackBarHostState: SnackbarHostState
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues = paddingValues)
            .consumeWindowInsets(paddingValues = paddingValues)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 8.dp)
        ) {
            items(state.visibleNodes) { node ->
                NodeItem(node = node, snackBarHostState = snackBarHostState)
            }

            item {
                if (state.isLoadingMore) {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.CenterHorizontally)
                    )
                } else if (state.visibleNodes.size < state.allNodes.size) {
                    Button(
                        onClick = { loadMoreNodes() },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(stringResource(id = R.string.load_more_button))
                    }
                }
            }
        }
    }
}