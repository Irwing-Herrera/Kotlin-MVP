package com.iherrera.kotlinmvp.login

import com.iherrera.kotlinmvp.login.model.LoginActivityModel
import com.iherrera.kotlinmvp.login.presenter.LoginActivityPresenter
import dagger.Module
import dagger.Provides

@Module
class LoginModule {

    @Provides
    fun provideLoginActivityPresenter(model: LoginActivityMVP.Model): LoginActivityMVP.Presenter {
        return LoginActivityPresenter(model)
    }

    @Provides
    fun provideLoginActivityModel(repository: LoginRepository): LoginActivityMVP.Model {
        return LoginActivityModel(repository)
    }

    @Provides
    fun provideLoginRepository(): LoginRepository = MemoryRepository()
}