package com.foodrunner.model

import com.google.gson.annotations.SerializedName

data class ForgotPasswordResponse (
    @SerializedName("data")
    var data: Data?
    ) {
        data class Data(
            @SerializedName("success")
            var success: Boolean?,
            @SerializedName("first_try")
            var firstTry:Boolean?
        )
    }