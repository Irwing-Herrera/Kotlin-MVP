package com.iherrera.kotlinmvp

import android.app.Application
import com.iherrera.kotlinmvp.di.component.ApplicationComponent
import com.iherrera.kotlinmvp.di.component.DaggerApplicationComponent
import com.iherrera.kotlinmvp.di.module.ApplicationModule
import com.iherrera.kotlinmvp.login.LoginModule

class BaseApp : Application() {

    private val component: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .loginModule(LoginModule())
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        component.inject(this)
    }
}