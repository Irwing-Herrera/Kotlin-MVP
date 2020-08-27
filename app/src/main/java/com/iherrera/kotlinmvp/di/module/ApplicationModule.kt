package com.iherrera.kotlinmvp.di.module

import android.app.Application
import com.iherrera.kotlinmvp.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val app: App) {

    @Provides
    @Singleton
    fun provideApplication(): Application = app

}