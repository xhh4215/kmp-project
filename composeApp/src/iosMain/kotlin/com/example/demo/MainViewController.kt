package com.example.demo

import androidx.compose.ui.window.ComposeUIViewController
import com.example.demo.di.commonModule
import org.koin.core.context.startKoin

fun MainViewController() = ComposeUIViewController {
    initKoin()
    App()
}