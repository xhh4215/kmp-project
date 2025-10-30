package com.example.demo

import com.example.demo.di.commonModule
import org.koin.core.context.startKoin

fun initKoin() {
    startKoin {
        modules(commonModule)
    }
}