package com.example.secondapp.domain.usecase

import com.example.secondapp.data.repository.UserRepository
import com.example.secondapp.domain.entity.User

class GetUserUseCase(
    private val userRepository: UserRepository
) {
    suspend fun invoke(email: String) : User? {
        return userRepository.getUser(email)
    }
}