package com.muniz.lightningclient

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class LightningClientApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@LightningClientApplication)
            androidLogger()
            modules(listOf(networkModule))
        }
    }

}