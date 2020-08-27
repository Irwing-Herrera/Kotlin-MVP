package com.iherrera.kotlinmvp.login

import com.iherrera.kotlinmvp.login.model.LoginActivityModel
import com.iherrera.kotlinmvp.login.presenter.LoginActivityPresenter
import dagger.Module
import dagger.Provides

/**
 * ???????
 */
@Module
class LoginModule {

    /**
     * ???????
     *
     * @param {LoginActivityMVP.Model} model
     * @return {LoginActivityMVP.Presenter}
     */
    @Provides
    fun provideLoginActivityPresenter(model: LoginActivityMVP.Model): LoginActivityMVP.Presenter {
        return LoginActivityPresenter(model)
    }

    /**
     * ???????????
     *
     * @param {LoginRepository} repository
     * @return {LoginActivityMVP.Model}
     */
    @Provides
    fun provideLoginActivityModel(repository: LoginRepository): LoginActivityMVP.Model {
        return LoginActivityModel(repository)
    }

    /**
     * ???????????
     *
     * @return {LoginRepository}
     */
    @Provides
    fun provideLoginRepository(): LoginRepository = MemoryRepository()
}