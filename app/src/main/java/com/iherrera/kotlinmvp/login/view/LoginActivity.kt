package com.iherrera.kotlinmvp.login.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.iherrera.kotlinmvp.BaseApp
import com.iherrera.kotlinmvp.R
import com.iherrera.kotlinmvp.login.LoginActivityMVP
import com.iherrera.kotlinmvp.utils.toast
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class LoginActivity : AppCompatActivity(), LoginActivityMVP.View {

    @Inject
    private lateinit var presenter: LoginActivityMVP.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.setView(this)

        buttonLogIn.setOnClickListener {
            presenter.loginButtonClicked()
        }
    }

    override fun getFirstName(): String {
        return editTextFirstName.text.toString()
    }

    override fun getLastName(): String {
        return editTextLastName.text.toString()
    }

    override fun showUserNotAvailable() {
        toast("Error, el usuario no está disponible")
    }

    override fun showInputError() {
        toast("Error, el nombre ni el apellido pueden estar vacíos")
    }

    override fun showUserSaved() {
        toast("¡Usuario guardado correctamente!")
    }

    override fun setFirstName(firstName: String) {
        editTextFirstName.setText(firstName)
    }

    override fun setLastName(lastName: String) {
        editTextLastName.setText(lastName)
    }
}