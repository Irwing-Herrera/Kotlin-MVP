package com.iherrera.kotlinmvp.login.model

/**
 * Modelo de Usuario
 */
data class User(
    /**
     * Nombre
     *
     * @property {String} firstName
     */
    val firstName: String,
    /**
     * Apellido
     *
     * @property {String} lastName
     */
    val lastName: String
)