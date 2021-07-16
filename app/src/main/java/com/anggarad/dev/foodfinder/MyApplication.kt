package com.anggarad.dev.foodfinder

import android.app.Application
import com.anggarad.dev.foodfinder.core.di.databaseModule
import com.anggarad.dev.foodfinder.core.di.networkModule
import com.anggarad.dev.foodfinder.core.di.repositoryModule
import com.anggarad.dev.foodfinder.di.useCaseModule
import com.anggarad.dev.foodfinder.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

open class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}