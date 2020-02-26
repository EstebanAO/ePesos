package com.example.epesos.login.view

import androidx.appcompat.app.AppCompatActivity
import com.example.epesos.R
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Toast
import com.example.epesos.login.model.LoginInteractor
import com.example.epesos.login.presenter.LoginPresenter

class LoginActivity : AppCompatActivity(), LoginView {

    private lateinit var loginPresenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.requestFeature(Window.FEATURE_NO_TITLE)
        supportActionBar?.hide()
        setContentView(R.layout.login_activity)
        loginPresenter = LoginPresenter(this, LoginInteractor())
    }

    override fun onResume() {
        super.onResume()
        loginPresenter.login()
    }

    override fun showProgress() {
        //progressBar.visibility = View.VISIBLE
        Toast.makeText(this, "Show progress", Toast.LENGTH_SHORT).show()
    }

    override fun hideProgress() {
        //progressBar.visibility = View.VISIBLE
        Toast.makeText(this, "Remove progress", Toast.LENGTH_SHORT).show()
    }

}
