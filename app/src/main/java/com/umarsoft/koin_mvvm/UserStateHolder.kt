package com.umarsoft.koin_mvvm

import com.umarsoft.koin_mvvm.data.UserRepository

class UserStateHolder(private val repository: UserRepository) {

    fun sayhello(name: String): String {
        val foundUser = repository.findUser(name)
        return foundUser?.let { "Hello $it from $this" } ?: "User $name not found"

    }
}