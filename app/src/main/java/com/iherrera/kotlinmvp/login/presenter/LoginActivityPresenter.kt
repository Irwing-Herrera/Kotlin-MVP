package com.iherrera.kotlinmvp.login.presenter

import androidx.annotation.Nullable
import com.iherrera.kotlinmvp.login.LoginActivityMVP
import com.iherrera.kotlinmvp.login.model.User


class LoginActivityPresenter(mvpModel: LoginActivityMVP.Model): LoginActivityMVP.Presenter {

    @Nullable
    private var myView: LoginActivityMVP.View? = null
    private val model: LoginActivityMVP.Model = mvpModel

    override fun setView(view: LoginActivityMVP.View) {
        myView = view
    }

    override fun loginButtonClicked() {
        if (myView != null) {
            if(myView!!.getFirstName().trim() == "" || myView!!.getLastName().trim() == ""){
                myView!!.showInputError();
            } else {
                model.createUser(myView!!.getFirstName().trim(), myView!!.getLastName().trim());
                myView!!.showUserSaved();
            }
        }
    }

    override fun getCurrentUser() {
        val user: User = model.getUser();

        if (user == null){
            if (myView != null){
                myView!!.showUserNotAvailable();
            }
        }else{
            if(myView != null){
                myView!!.setFirstName(user.firstName);
                myView!!.setLastName(user.lastName);
            }
        }
    }
}