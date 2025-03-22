package com.muniz.lightningclient.di

import com.muniz.lightningclient.viewmodels.NodesListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { NodesListViewModel(get()) }

}