package com.iherrera.kotlinmvp.login

import com.iherrera.kotlinmvp.login.model.User

/**
 * Interface con logica de MVP
 */
interface LoginActivityMVP {

    /**
     * Interfaz de Vista
     */
    interface View {
        /**
         * Obtener Nombre
         *
         * @return {String}
         */
        fun getFirstName(): String

        /**
         * Obtener Apellido
         *
         * @return {String}
         */
        fun getLastName(): String

        /**
         * Mostrar error de usuario no disponible
         */
        fun showUserNotAvailable()

        /**
         * Mostrar error de inputs vacios
         */
        fun showInputError()

        /**
         * Mostrar mensaje de usuario almacenado
         */
        fun showUserSaved()

        /**
         * Asignar valor a Nombre
         *
         * @param {String} firstName
         */
        fun setFirstName(firstName: String)

        /**
         * Asignar valor a Apellido
         *
         * @param {String} lastName
         */
        fun setLastName(lastName: String)
    }

    /**
     * Interfaz de Presentador
     */
    interface Presenter {
        /**
         * Asignar vista
         *
         * @param {LoginActivityMVP.View} view
         */
        fun setView(view: View)

        /**
         * Evento, click en boton de login
         */
        fun loginButtonClicked()

        /**
         * Obtener usuario actual
         */
        fun getCurrentUser()
    }

    /**
     * Interfaz del Modelo
     */
    interface Model {
        /**
         * Crear nuevo Usuario
         *
         * @param {String} firstName
         * @param {String} lastName
         */
        fun createUser(firstName: String, lastName: String)

        /**
         * Obtener usuario
         *
         * @return {User}
         */
        fun getUser(): User
    }
}