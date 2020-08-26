package com.iherrera.kotlinmvp.login

import com.iherrera.kotlinmvp.login.model.User

class MemoryRepository : LoginRepository {

    private lateinit var user: User

    override fun saveUser(user: User) {
        if(user == null){
            this.user = getUser();
        }
        this.user = user;
    }

    override fun getUser(): User {
        if (this.user == null){
            this.user = User("Antonio", "Banderas")
            return this.user;
        }else {
            return this.user;
        }
    }
}