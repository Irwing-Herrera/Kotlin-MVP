package com.iherrera.kotlinmvp.login

import com.iherrera.kotlinmvp.login.model.User

/**
 * Interface de acciones con Repositorio
 */
interface LoginRepository {
    /**
     * Guardar Usuario
     *
     * @param {User} user
     */
    fun saveUser(user: User)
    /**
     * Obtener Usuario
     *
     * @return {User}
     */
    fun getUser(): User
}