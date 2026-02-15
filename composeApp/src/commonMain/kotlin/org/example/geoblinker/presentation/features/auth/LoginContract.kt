package org.example.geoblinker.presentation.features.auth

// Состояние экрана (данные)
data class LoginState(
    val login: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val error: String? = null
)

// События (действия пользователя)
sealed interface LoginEvent {
    data class OnLoginChanged(val value: String) : LoginEvent
    data class OnPasswordChanged(val value: String) : LoginEvent
    data object OnLoginClicked : LoginEvent
}