package com.bbm

import android.app.Application
import com.bbm.android_assesment.di.koinModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class AtmApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        // DI
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@AtmApplication)
            modules(koinModules)
        }
    }
}