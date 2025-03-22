package com.muniz.lightningclient.di

import com.muniz.lightningclient.data.network.RetrofitClient
import com.muniz.lightningclient.data.remote.NodesApi
import org.koin.dsl.module

val networkModule = module {

    single { RetrofitClient.createService(NodesApi::class.java) }

}