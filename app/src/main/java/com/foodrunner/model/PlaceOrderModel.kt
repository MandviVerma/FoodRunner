package com.foodrunner.model

import com.google.gson.annotations.SerializedName

data class PlaceOrderModel(
    @SerializedName("user_id")
    var userId: String,
    @SerializedName("restaurant_id")
    var restaurantId: String,
    @SerializedName("total_cost")
    var totalCost: String,
    @SerializedName("food")
    var foodList: ArrayList<Food>
)

data class Food(
    @SerializedName("food_item_id")
    var foodItemId: String
)