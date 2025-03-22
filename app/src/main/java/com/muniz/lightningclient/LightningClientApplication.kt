package com.muniz.lightningclient

import android.app.Application
import com.muniz.lightningclient.di.dataSourceModule
import com.muniz.lightningclient.di.networkModule
import com.muniz.lightningclient.di.repositoryModule
import com.muniz.lightningclient.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class LightningClientApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@LightningClientApplication)
            androidLogger()
            modules(listOf(networkModule, dataSourceModule, repositoryModule, viewModelModule))
        }
    }

}