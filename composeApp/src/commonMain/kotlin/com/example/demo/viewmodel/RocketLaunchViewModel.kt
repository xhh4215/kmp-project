package com.example.demo.viewmodel

import RocketLaunch
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
 import com.example.demo.network.SpaceXApi
 import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

open class KmpViewModel {
    val viewModelScope = CoroutineScope(SupervisorJob() + Dispatchers.Main)
    open fun onCleared() { viewModelScope.cancel() }
}


class RocketLaunchViewModel(private val sdk: SpaceXApi) : KmpViewModel() {



    private val _state: MutableStateFlow<RocketLaunchScreenState> = MutableStateFlow(RocketLaunchScreenState())
    val state: StateFlow<RocketLaunchScreenState> = _state



    fun loadLaunches() {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true, launches = emptyList())
            try {
                val launches = sdk.getAllLaunches()
                _state.value = _state.value.copy(isLoading = false, launches = launches)
                println("RocketLaunchViewModel: ${state.value.launches.size}")
            } catch (e: Exception) {
                _state.value = _state.value.copy(isLoading = false, launches = emptyList())
            }
        }
    }
}

data class RocketLaunchScreenState(
    val isLoading: Boolean = false,
    val launches: List<RocketLaunch> = emptyList()
)