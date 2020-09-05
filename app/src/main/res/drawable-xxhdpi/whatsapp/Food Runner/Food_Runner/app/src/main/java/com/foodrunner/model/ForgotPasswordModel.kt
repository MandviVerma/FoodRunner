package com.foodrunner.model


import com.google.gson.annotations.SerializedName

data class ForgotPasswordModel(
    @SerializedName("mobile_number")
    var mobileNumber: String,
    @SerializedName("email")
    var email: String
)