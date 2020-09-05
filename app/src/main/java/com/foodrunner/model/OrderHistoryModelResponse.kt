package com.foodrunner.model

import com.google.gson.annotations.SerializedName

data class OrderHistoryModelResponse(
    @SerializedName("data")
    var data: Data?
) {
    data class Data(
        @SerializedName("success")
        var success: Boolean?,
        @SerializedName("data")
        var data: List<Orders?>?
    ) {
        data class Orders(
            @SerializedName("order_id")
            var orderId: String,
            @SerializedName("restaurant_name")
            var restaurantName: String?,
            @SerializedName("total_cost")
            var totalCost: String?,
            @SerializedName("order_placed_at")
            var orderPlacedAt: String?,
            @SerializedName("food_items")
            var foodItems: List<FoodItems?>?
        )
        {
            data class FoodItems(
                @SerializedName("food_item_id")
                var foodItemId: String,
                @SerializedName("name")
                var foodName: String?,
                @SerializedName("cost")
                var foodCost: String?
            )

        }
    }
}