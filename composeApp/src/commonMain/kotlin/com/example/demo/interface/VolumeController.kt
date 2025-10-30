package com.example.demo.`interface`


import kotlinx.coroutines.flow.StateFlow

interface VolumeController {
    val volumeFlow: StateFlow<Float> // 当前音量(0f ~ 1f)
    fun setVolume(value: Float)
    fun startObserve()
    fun stopObserve()
}
