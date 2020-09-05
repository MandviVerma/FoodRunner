package com.foodrunner.model

import com.google.gson.annotations.SerializedName

data class CartResponse(
    @SerializedName("data")
    var data: Data?
) {
    data class Data(
        @SerializedName("success")
        var success: Boolean?
    )
}