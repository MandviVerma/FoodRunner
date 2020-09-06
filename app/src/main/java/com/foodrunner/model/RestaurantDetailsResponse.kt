package com.foodrunner.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class RestaurantDetailsResponse(
    @SerializedName("data")
    var data: Data?
) {
    data class Data(
        @SerializedName("success")
        var success: Boolean?,
        @SerializedName("data")
        var data: List<MenuData?>?
    ) {
        @Entity(primaryKeys = ["id"])
        data class MenuData(
            @ColumnInfo(name = "id")
            @SerializedName("id")
            var id: String,
            @ColumnInfo(name = "name")
            @SerializedName("name")
            var name: String?,
            @ColumnInfo(name = "restaurant_id")
            @SerializedName("restaurant_id")
            var restaurantId: String?,
            @ColumnInfo(name = "cost_for_one")
            @SerializedName("cost_for_one")
            var costForOne: String?,
            var isFav: Boolean? = null
        )
    }
}