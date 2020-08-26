package com.iherrera.kotlinmvp.di.component

import com.iherrera.kotlinmvp.BaseApp
import com.iherrera.kotlinmvp.di.module.ApplicationModule
import com.iherrera.kotlinmvp.login.LoginModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class,LoginModule::class])
interface ApplicationComponent {
    fun inject(application: BaseApp)
}