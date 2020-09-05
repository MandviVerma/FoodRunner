package com.foodrunner.model

import com.google.gson.annotations.SerializedName


data class AuthModel(
    @SerializedName("name")
    var name: String? = "",
    @SerializedName("mobile_number")
    var mobileNumber: String = "",
    @SerializedName("password")
    var password: String? = "",
    @SerializedName("address")
    var address: String? = "",
    @SerializedName("email")
    var email: String = ""
)