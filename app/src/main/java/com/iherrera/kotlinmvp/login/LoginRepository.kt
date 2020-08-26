package com.iherrera.kotlinmvp.login

import com.iherrera.kotlinmvp.login.model.User

interface LoginRepository {
    fun saveUser(user: User)
    fun getUser(): User
}