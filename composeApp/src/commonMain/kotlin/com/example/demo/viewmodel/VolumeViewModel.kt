package com.example.demo.viewmodel


import com.example.demo.`interface`.VolumeController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class VolumeViewModel(private val controller: VolumeController) {
    private val scope = CoroutineScope(Dispatchers.Default)
    private val _volume = MutableStateFlow(0f)
    val volume = _volume.asStateFlow()

    init {
        controller.startObserve()
        scope.launch {
            controller.volumeFlow.collectLatest {
                _volume.value = it
            }
        }
    }

    fun onSliderChange(value: Float) {
        _volume.value = value
        controller.setVolume(value)
    }

    fun dispose() {
        controller.stopObserve()
    }
}
