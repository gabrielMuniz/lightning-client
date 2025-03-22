package com.muniz.lightningclient.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muniz.lightningclient.domain.model.Node
import com.muniz.lightningclient.domain.model.response.Response
import com.muniz.lightningclient.domain.repositories.NodesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class NodesListViewModel(private val repository: NodesRepository) : ViewModel() {

    private val _state = MutableStateFlow(NodesListState())
    val state: StateFlow<NodesListState> = _state

    fun getTopHundredNodes() {
        viewModelScope.launch {
            _state.value = NodesListState(isLoading = true)
            repository.getNodesConnectivity().collect { response ->
                when (response) {
                    is Response.Error -> {
                        _state.update{ it.copy(isLoading = false, error = true) }
                    }

                    is Response.Success -> {
                        with(response.data) {
                            _state.value = NodesListState(
                                allNodes = this,
                                visibleNodes = this.take(_state.value.pageSize),
                                isLoading = false,
                                error = false,
                                isLoadingMore = false
                            )
                        }
                    }
                }

            }
        }
    }

    fun loadMoreNodes() {
        if (_state.value.isLoadingMore) return

        viewModelScope.launch {
            _state.value = _state.value.copy(isLoadingMore = true)

            val nextPage = _state.value.currentPage + 1
            val startIndex = (nextPage - 1) * _state.value.pageSize
            val endIndex = startIndex + _state.value.pageSize
            val newItems = _state.value.allNodes.subList(
                startIndex, endIndex.coerceAtMost(_state.value.allNodes.size)
            )

            if (newItems.isNotEmpty()) {
                _state.value = _state.value.copy(
                    visibleNodes = _state.value.visibleNodes + newItems,
                    currentPage = nextPage,
                    isLoadingMore = false
                )
            } else {
                _state.value = _state.value.copy(isLoadingMore = false)
            }
        }
    }

}

data class NodesListState(
    val isLoading: Boolean = false,
    val isLoadingMore: Boolean = false,
    val allNodes: List<Node> = emptyList(),
    val visibleNodes: List<Node> = emptyList(),
    val error: Boolean = false,
    val currentPage: Int = 1,
    val pageSize: Int = 20
)