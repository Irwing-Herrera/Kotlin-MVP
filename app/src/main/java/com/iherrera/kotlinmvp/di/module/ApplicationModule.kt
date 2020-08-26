package com.iherrera.kotlinmvp.di.module

import android.app.Application
import com.iherrera.kotlinmvp.BaseApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val baseBaseApp: BaseApp) {
    @Provides @Singleton fun provideApplication() : Application = baseBaseApp
}