package com.example.epesos.login.model

import android.os.Handler

class LoginInteractor {
    companion object {
        private val TAG: String = LoginInteractor::class.java.simpleName
    }

    interface OnFinishedListener {
        fun onResultSuccess(logged_in :Boolean)
        fun onResultFail(strError: String)
    }

    fun requestLogin(onFinishedListener: OnFinishedListener) {

        // This will always return true for mocking purposes
        if (true) {
            val handler = Handler()
            handler.postDelayed({ onFinishedListener.onResultSuccess(true) }, 1000)

        } else {
            onFinishedListener.onResultFail("Error connecting to fake server")
        }
    }
}