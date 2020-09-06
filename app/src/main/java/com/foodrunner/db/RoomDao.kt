package com.foodrunner.db

import androidx.room.*
import com.foodrunner.model.FavoriteModel
import com.foodrunner.model.RestaurantDetailsResponse

@Dao
interface RoomDao {

    @Insert
    fun addToFavorite(restaurant: FavoriteModel)

    @Query("SELECT * FROM FavoriteModel")
    fun getFavoriteRestaurantList() : List<FavoriteModel>

    @Delete
    fun removeFromFav(restaurant: FavoriteModel)

    @Insert
    fun addToCart(food: RestaurantDetailsResponse.Data.MenuData)

    @Query("SELECT * FROM MenuData")
    fun getCart() : List<RestaurantDetailsResponse.Data.MenuData>

    @Delete
    fun removeFromCart(food: RestaurantDetailsResponse.Data.MenuData)

    @Query("DELETE FROM MenuData")
    fun clearCart()
}