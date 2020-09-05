package com.foodrunner.db

import androidx.room.*
import com.foodrunner.model.AuthModel
import com.foodrunner.model.FavoriteModel
import com.foodrunner.model.MenuModelResponse


@Dao
interface RoomDao {


    @Insert
    fun addToFavorite(restaurant: FavoriteModel)

    @Query("SELECT * FROM FavoriteModel")
    fun getFavoriteRestaurantList() : List<FavoriteModel>

    @Delete
    fun removeFromFav(restaurant: FavoriteModel)

    @Insert
    fun addToCart(food: MenuModelResponse.Data.MenuData)

    @Query("SELECT * FROM MenuData")
    fun getCart() : List<MenuModelResponse.Data.MenuData>

    @Delete
    fun removeFromCart(food: MenuModelResponse.Data.MenuData)

    @Query("DELETE FROM MenuData")
    fun clearCart()

}