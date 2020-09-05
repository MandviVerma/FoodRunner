package com.foodrunner.model

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(primaryKeys = ["phone","id"])
data class FavoriteModel(
    @ColumnInfo(name = "phone")
    var mobileNumber: String = "",
    @ColumnInfo(name ="id")
    var id: String,
    @ColumnInfo(name ="name")
    var name: String? = null,
    @ColumnInfo(name="rating")
    var rating: String? = null,
    @ColumnInfo(name ="cost_for_one")
    var costForOne: String? = null,
    @ColumnInfo(name="image_url")
    var imageUrl: String? = null
)