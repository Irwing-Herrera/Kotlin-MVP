package com.iherrera.kotlinmvp.login.presenter

import com.iherrera.kotlinmvp.login.LoginActivityMVP
import com.iherrera.kotlinmvp.login.model.User


class LoginActivityPresenter(mvpModel: LoginActivityMVP.Model) : LoginActivityMVP.Presenter {

    /**
     * Agregar Vista a Presentador
     *
     * @property {LoginActivityMVP.View} myView
     */
    private lateinit var myView: LoginActivityMVP.View

    /**
     * Agregar Modelo a Presentador
     *
     * @property {LoginActivityMVP.Model} model
     */
    private val model: LoginActivityMVP.Model = mvpModel

    override fun setView(view: LoginActivityMVP.View) {
        myView = view
    }

    override fun loginButtonClicked() {
        if (myView != null) {
            if (myView!!.getFirstName().trim() == "" || myView!!.getLastName().trim() == "") {
                myView!!.showInputError();
            } else {
                model.createUser(myView!!.getFirstName().trim(), myView!!.getLastName().trim());
                myView!!.showUserSaved();
            }
        }
    }

    override fun getCurrentUser() {
        val user: User = model.getUser();

        if (user == null) {
            if (myView != null) {
                myView!!.showUserNotAvailable();
            }
        } else {
            if (myView != null) {
                myView!!.setFirstName(user.firstName);
                myView!!.setLastName(user.lastName);
            }
        }
    }
}