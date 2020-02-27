package com.example.epesos.home.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Service (
    var supplier_id : String,
    var category :String,
    var name :String,
    var url_logo :String
) : Parcelable {
    constructor() : this(
        supplier_id = "",
        category = "",
        name = "",
        url_logo = ""
    )
}
