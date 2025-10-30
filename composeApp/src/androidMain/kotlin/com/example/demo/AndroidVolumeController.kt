package com.example.demo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.media.AudioManager
import com.example.demo.`interface`.VolumeController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class AndroidVolumeController(private val context: Context) : VolumeController {
    private val audioManager = context.getSystemService(Context.AUDIO_SERVICE) as AudioManager
    private val _volumeFlow = MutableStateFlow(getSystemVolume())
    override val volumeFlow = _volumeFlow.asStateFlow()

    private val receiver = object : BroadcastReceiver() {
        override fun onReceive(ctx: Context?, intent: Intent?) {
            if (intent?.action == "android.media.VOLUME_CHANGED_ACTION") {
                _volumeFlow.value = getSystemVolume()
            }
        }
    }

    private fun getSystemVolume(): Float {
        val max = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC)
        val current = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC)
        return current.toFloat() / max
    }

    override fun setVolume(value: Float) {
        val max = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC)
        val newVolume = (value * max).toInt().coerceIn(0, max)
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, newVolume, 0)
        _volumeFlow.value = value
    }

    override fun startObserve() {
        context.registerReceiver(receiver, IntentFilter("android.media.VOLUME_CHANGED_ACTION"))
    }

    override fun stopObserve() {
        context.unregisterReceiver(receiver)
    }
}
