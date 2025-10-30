package com.example.demo

import android.app.Application
import com.example.demo.di.commonModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        //启动依赖注入框架
        startKoin {
            androidContext(this@MainApplication)
            modules(commonModule)
        }
    }
}