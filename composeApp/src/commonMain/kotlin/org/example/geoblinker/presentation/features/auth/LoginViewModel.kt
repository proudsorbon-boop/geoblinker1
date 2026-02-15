package org.example.geoblinker.presentation.features.auth

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel : ScreenModel {
    private val _uiState = MutableStateFlow(LoginState())
    val uiState = _uiState.asStateFlow()

    fun handleEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.OnLoginChanged -> _uiState.update { it.copy(login = event.value) }
            is LoginEvent.OnPasswordChanged -> _uiState.update { it.copy(password = event.value) }
            is LoginEvent.OnLoginClicked -> login()
        }
    }

    private fun login() {
        screenModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            // Имитация загрузки (пока нет API)
            delay(1500)
            _uiState.update { it.copy(isLoading = false) }
            println("Попытка входа: ${_uiState.value.login}")
        }
    }
}