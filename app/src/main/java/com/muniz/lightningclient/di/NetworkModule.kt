package com.muniz.lightningclient.di

import org.koin.dsl.module

val networkModule = module {

    single { RetrofitClient.createService(ExchangeApi::class.java) }

}