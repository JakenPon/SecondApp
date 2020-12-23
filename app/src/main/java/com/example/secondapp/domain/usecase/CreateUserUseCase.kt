package com.example.secondapp.domain.usecase

import com.example.secondapp.data.repository.UserRepository
import com.example.secondapp.domain.entity.User

class CreateUserUseCase(
    private val userRepository: UserRepository
) {
    suspend fun invoke(user: User){
        userRepository.createUser(user)
    }
}