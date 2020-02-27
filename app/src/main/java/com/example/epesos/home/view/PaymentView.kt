package com.example.epesos.home.view

import com.example.epesos.home.model.Company

interface PaymentView {
    fun setPhoneServices( companies :List<Company> )
    fun setServices( companies :List<Company> )
    fun setCommunicationServices( companies :List<Company> )
}