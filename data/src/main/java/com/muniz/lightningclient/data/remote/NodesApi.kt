package com.muniz.lightningclient.data.remote

import com.muniz.lightningclient.data.model.nodes.NodeResponse
import retrofit2.Call
import retrofit2.http.GET

interface NodesApi {

    @GET("lightning/nodes/rankings/connectivity")
    fun getNodesConnectivity(): Call<List<NodeResponse>>

}