package com.iherrera.kotlinmvp.login.model

import com.iherrera.kotlinmvp.login.LoginActivityMVP
import com.iherrera.kotlinmvp.login.LoginRepository

class LoginActivityModel(loginRepository: LoginRepository) : LoginActivityMVP.Model {

    private val repository: LoginRepository = loginRepository

    override fun createUser(firstName: String, lastName: String) {
        repository.saveUser(User(firstName, lastName))
    }

    override fun getUser(): User {
        return repository.getUser()
    }
}