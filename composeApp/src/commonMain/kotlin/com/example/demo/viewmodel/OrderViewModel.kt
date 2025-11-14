package com.example.demo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class OrderViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(0)
    val uiState: StateFlow<Int> = _uiState.asStateFlow()
    // ...
}