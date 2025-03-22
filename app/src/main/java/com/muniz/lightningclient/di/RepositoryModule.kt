package com.muniz.lightningclient.di

import com.muniz.lightningclient.data.repositories.NodesRepositoryImpl
import com.muniz.lightningclient.domain.repositories.NodesRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { NodesRepositoryImpl(get()) as NodesRepository }
}