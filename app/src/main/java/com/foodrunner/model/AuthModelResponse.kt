package com.foodrunner.model

import com.google.gson.annotations.SerializedName

data class AuthModelResponse(
    @SerializedName("data")
    var data: Data?
) {
    data class Data(
        @SerializedName("success")
        var success: Boolean?,
        @SerializedName("error_message")
        var errorMessage: String?,
        @SerializedName("data")
        var data: Data?
    ) {
        data class Data(
            @SerializedName("user_id")
            var userId: String?,
            @SerializedName("name")
            var name: String?,
            @SerializedName("email")
            var email: String?,
            @SerializedName("mobile_number")
            var mobileNumber: String?,
            @SerializedName("address")
            var address: String?
        )
    }
}