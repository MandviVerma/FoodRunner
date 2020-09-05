package com.foodrunner.model

import com.google.gson.annotations.SerializedName

data class LoginModel(
    @SerializedName("mobile_number")
    var mobileNumber: String,
    @SerializedName("password")
    var password: String
)