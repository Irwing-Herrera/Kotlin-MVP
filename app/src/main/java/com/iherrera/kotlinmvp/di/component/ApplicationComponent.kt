package com.iherrera.kotlinmvp.di.component

import com.iherrera.kotlinmvp.di.module.ApplicationModule
import com.iherrera.kotlinmvp.login.LoginModule
import com.iherrera.kotlinmvp.login.view.LoginActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, LoginModule::class])
interface ApplicationComponent {

    /**
     * Permitir hacer inyeccion en LoginActivity
     *
     * @param {LoginActivity} loginActivity
     */
    fun inject(loginActivity: LoginActivity)
}