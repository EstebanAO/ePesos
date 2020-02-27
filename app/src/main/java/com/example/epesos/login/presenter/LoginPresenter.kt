package com.example.epesos.login.presenter

import com.example.epesos.login.model.LoginInteractor
import com.example.epesos.login.view.LoginView

class LoginPresenter(private var loginView: LoginView?, private val loginInteractor: LoginInteractor)
    : LoginInteractor.OnFinishedListener {

    fun login() {
        loginView?.showProgress()
        loginInteractor.requestLogin(this)
    }

    fun onDestroy() {
        loginView = null
    }

    override fun onResultSuccess(logged_in :Boolean ) {
        loginView?.login()
    }

    override fun onResultFail(strError: String) {
        loginView?.hideProgress()
    }
}