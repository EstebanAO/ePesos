package com.example.epesos.login.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.example.epesos.R
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.epesos.home.view.MainActivity
import com.example.epesos.login.model.LoginInteractor
import com.example.epesos.login.presenter.LoginPresenter
import kotlinx.android.synthetic.main.login_activity.*

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
        login_btn.setOnClickListener { loginPresenter.login() }
    }

    override fun showProgress() {
        // Show progressbar code
        //progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        // Dismiss progressbar code
        //progressBar.visibility = View.GONE
    }

    override fun login() {
        val intent = Intent(this, MainActivity::class.java)
        ContextCompat.startActivity(this, intent, null)
    }

}
