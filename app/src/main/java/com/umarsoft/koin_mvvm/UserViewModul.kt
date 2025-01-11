package com.umarsoft.koin_mvvm

import androidx.lifecycle.ViewModel
import com.umarsoft.koin_mvvm.data.UserRepository

class UserViewModul(private val repository: UserRepository) : ViewModel() {

    fun sayhello(name: String): String {
        val founduser = repository.findUser(name)
        return founduser?.let {"Hello $it from $this" } ?: "User $name not found"
    }
}