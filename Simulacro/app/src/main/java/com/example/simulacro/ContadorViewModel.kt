package com.example.simulacro

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ContadorViewModel : ViewModel() {
    private val _cont = MutableStateFlow(GameUiState(0))
    var cont : StateFlow<GameUiState> = _cont.asStateFlow()

    fun sumar() {
        _cont.update { currentState ->
            currentState.copy(contador = currentState.contador + 1)
        }
    }

    fun restar() {
        _cont.update { currentState ->
            currentState.copy(contador = currentState.contador - 1)
        }
    }
}