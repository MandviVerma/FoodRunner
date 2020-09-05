package com.foodrunner.model

import com.google.gson.annotations.SerializedName

data class ResetPasswordResponse (
    @SerializedName("data")
    var data: Data?
) {
    data class Data(
        @SerializedName("success")
        var success: Boolean?,
        @SerializedName("successMessage")
        var successMessage: String?
    )
}