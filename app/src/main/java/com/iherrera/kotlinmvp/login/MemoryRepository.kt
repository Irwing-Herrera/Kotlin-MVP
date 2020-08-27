package com.iherrera.kotlinmvp.login

import com.iherrera.kotlinmvp.login.model.User

/**
 * Acciones que interactuan con (Room,Firebase,etc)
 */
class MemoryRepository : LoginRepository {
    /**
     * Instancia de Usuario
     *
     * @property {User?} myUser
     */
    private var myUser: User? = null

    override fun saveUser(user: User) {
        if(user == null){
            myUser = getUser();
        }
        myUser = user;
    }

    override fun getUser(): User {
        if (myUser == null){
            myUser = User("Antonio", "Banderas")
            return myUser!!;
        }else {
            return myUser!!;
        }
    }
}