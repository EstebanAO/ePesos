package com.example.epesos.home.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.epesos.R
import com.example.epesos.home.model.Company
import com.example.epesos.home.model.PaymentInteractor
import com.example.epesos.home.presenter.PaymentPresenter
import com.google.gson.GsonBuilder
import org.json.JSONObject
import java.io.InputStream

class PaymentFragment : androidx.fragment.app.Fragment(), PaymentView {
    private lateinit var paymentPresenter: PaymentPresenter
    private lateinit var recyclerPhoneServices: RecyclerView
    private lateinit var recyclerServices: RecyclerView
    private lateinit var recyclerCommunicationServices: RecyclerView


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.payment_fragment, container, false)

        recyclerPhoneServices = view.findViewById(R.id.recycler_phone_services)
        recyclerServices = view.findViewById(R.id.recycler_services)
        recyclerCommunicationServices = view.findViewById(R.id.recycler_communication)

        recyclerPhoneServices.layoutManager = GridLayoutManager(context, 3)
        recyclerServices.layoutManager = GridLayoutManager(context, 3)
        recyclerCommunicationServices.layoutManager = GridLayoutManager(context, 3)

        paymentPresenter = PaymentPresenter(this, PaymentInteractor())
        paymentPresenter.getPhoneServices(activity!!, "TiempoAire.json")
        paymentPresenter.getServices(activity!!, "PagoDeServicios.json")
        paymentPresenter.getCommunicationServices(activity!!, "PagoDeServicios.json")

        return view
    }

    override fun setPhoneServices(companies: List<Company>) {
        recyclerPhoneServices.adapter = ServiceAdapter(companies, activity!!)
    }

    override fun setServices(companies: List<Company>) {
        recyclerServices.adapter = ServiceAdapter(companies, activity!!)
    }

    override fun setCommunicationServices(companies: List<Company>) {
        recyclerCommunicationServices.adapter = ServiceAdapter(companies, activity!!)
    }
}

