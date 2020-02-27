package com.example.epesos.home.model
import android.content.Context
import java.io.InputStream

class PaymentInteractor {
    companion object {
        private val TAG: String = PaymentInteractor::class.java.simpleName
    }

    interface OnFinishedListener {
        fun onResultSuccessPhoneServices(json :String)
        fun onResultSuccessServices(json :String)
        fun onResultSuccessCommunicationServices(json :String)
        fun onResultFail(strError: String)
    }

    fun getPhoneServices(filename :String, context: Context, onFinishedListener: OnFinishedListener){
        val phoneServices = readJSONFromAsset(filename, context)
        if (phoneServices != "error") {
            onFinishedListener.onResultSuccessPhoneServices(phoneServices)
        } else {
            onFinishedListener.onResultFail("Failed to retrieve json.")
        }
    }

    fun getServices(filename :String, context: Context, onFinishedListener: OnFinishedListener){
        val services = readJSONFromAsset(filename, context)
        if (services != "error") {
            onFinishedListener.onResultSuccessServices(services)
        } else {
            onFinishedListener.onResultFail("Failed to retrieve json.")
        }
    }

    fun getCommunicationServices(filename :String, context: Context, onFinishedListener: OnFinishedListener){
        val phoneServices = readJSONFromAsset(filename, context)
        if (phoneServices != "error") {
            onFinishedListener.onResultSuccessCommunicationServices(phoneServices)
        } else {
            onFinishedListener.onResultFail("Failed to retrieve json.")
        }
    }

    fun readJSONFromAsset(filename :String, context: Context) : String {
        var json: String? = null
        try {
            val  inputStream: InputStream = context.assets.open(filename)
            json = inputStream.bufferedReader().use{it.readText()}
        } catch (ex: Exception) {
            ex.printStackTrace()
            return "error"
        }
        return json
    }
}