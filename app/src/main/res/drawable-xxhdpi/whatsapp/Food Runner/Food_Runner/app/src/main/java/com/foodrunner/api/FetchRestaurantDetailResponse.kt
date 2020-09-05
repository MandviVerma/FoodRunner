package com.foodrunner.api

import com.google.gson.annotations.SerializedName

data class FetchRestaurantDetailResponse(
    @SerializedName("data")
    var data: Data?
) {
    data class Data(
        @SerializedName("success")
        var success: Boolean?,
        @SerializedName("data")
        var data: List<InternalData?>?
    ) {
        data class InternalData(
            @SerializedName("id")
            var id: String?,
            @SerializedName("name")
            var name: String?,
            @SerializedName("rating")
            var rating: String?,
            @SerializedName("cost_for_one")
            var costForOne: String?,
            @SerializedName("image_url")
            var imageUrl: String?,
            var isFav :Boolean? = null
        )
    }
}