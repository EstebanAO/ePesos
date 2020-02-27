package com.example.epesos.home.presenter

import android.content.Context
import com.example.epesos.home.model.Company
import com.example.epesos.home.model.PaymentInteractor
import com.example.epesos.home.view.PaymentView
import com.google.gson.GsonBuilder
import org.json.JSONObject

class PaymentPresenter(private var paymentView: PaymentView?, private val paymentInteractor: PaymentInteractor)
    : PaymentInteractor.OnFinishedListener {

    fun getPhoneServices(context: Context, filename :String) {
        paymentInteractor.getPhoneServices(filename, context, this)
    }

    fun getServices(context: Context, filename :String) {
        paymentInteractor.getServices(filename, context, this)
    }

    fun getCommunicationServices(context: Context, filename :String) {
        paymentInteractor.getCommunicationServices(filename, context, this)
    }

    override fun onResultSuccessPhoneServices(json :String ) {
        val obj = JSONObject(json)
        val data = obj["data"].toString()
        val gson = GsonBuilder().create()
        val companies = gson.fromJson(data, Array<Company>::class.java).toList()
        paymentView?.setPhoneServices(companies)
    }

    override fun onResultSuccessServices(json :String ) {
        val obj = JSONObject(json)
        val data = obj["data"].toString()
        val gson = GsonBuilder().create()
        val companies = gson.fromJson(data, Array<Company>::class.java).toList()
        val filteredCompanies = companies.filter { c -> c.category == "Pagar Servicios" }
        paymentView?.setServices(filteredCompanies)
    }

    override fun onResultSuccessCommunicationServices(json :String ) {
        val obj = JSONObject(json)
        val data = obj["data"].toString()
        val gson = GsonBuilder().create()
        val companies = gson.fromJson(data, Array<Company>::class.java).toList()
        val filteredCompanies = companies.filter { c -> c.category == "Internet y Televisión" }
        paymentView?.setCommunicationServices(filteredCompanies)
    }

    override fun onResultFail(strError: String) {

    }
}