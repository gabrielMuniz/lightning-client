package com.muniz.lightningclient.di

import com.muniz.lightningclient.data.datasource.NodesDataSource
import com.muniz.lightningclient.data.datasource.NodesDataSourceImpl
import org.koin.dsl.module

val dataSourceModule = module {
    factory { NodesDataSourceImpl(get()) as NodesDataSource }
}