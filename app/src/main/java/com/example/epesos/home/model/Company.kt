package com.example.epesos.home.model

data class Company (
    var supplier_id : String,
    var category :String,
    var name :String,
    var url_logo :String
) {
    constructor() : this(
        supplier_id = "",
        category = "",
        name = "",
        url_logo = ""
    )
}
