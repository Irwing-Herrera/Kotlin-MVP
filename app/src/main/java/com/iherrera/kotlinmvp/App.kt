package com.iherrera.kotlinmvp

import android.app.Application
import com.iherrera.kotlinmvp.di.component.ApplicationComponent
import com.iherrera.kotlinmvp.di.component.DaggerApplicationComponent
import com.iherrera.kotlinmvp.di.module.ApplicationModule

/**
 *
 */
class App : Application() {

    /**
     * Intancia de ApplicationComponent
     *
     * @property {ApplicationComponent} component
     */
    private lateinit var component: ApplicationComponent


    override fun onCreate() {
        super.onCreate()
        component =
            DaggerApplicationComponent.builder().applicationModule(ApplicationModule(this)).build()
    }

    /**
     * Obtener intancia de ApplicationComponent
     *
     * @return {ApplicationComponent}
     */
    fun getComponent() = component

}