package org.example.geoblinker.domain.repository

import io.ktor.client.*
import kotlinx.serialization.Serializable

@Serializable
data class LoginResponse(val sid: String?, val token: String?)

class AuthRepository(private val client: HttpClient) {
    suspend fun loginToBackend(login: String, pass: String): LoginResponse? {
        kotlinx.coroutines.delay(800)
        return LoginResponse("demo_sid_123", "demo_token")
    }
}
