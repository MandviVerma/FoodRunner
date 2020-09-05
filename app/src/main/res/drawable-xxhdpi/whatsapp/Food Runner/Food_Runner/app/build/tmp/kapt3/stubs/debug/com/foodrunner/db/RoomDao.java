package com.foodrunner.db;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\'J\b\u0010\t\u001a\u00020\u0003H\'J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bH\'J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u000bH\'J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\'\u00a8\u0006\u000f"}, d2 = {"Lcom/foodrunner/db/RoomDao;", "", "addToCart", "", "food", "Lcom/foodrunner/model/MenuModelResponse$Data$MenuData;", "addToFavorite", "restaurant", "Lcom/foodrunner/model/FavoriteModel;", "clearCart", "getCart", "", "getFavoriteRestaurantList", "removeFromCart", "removeFromFav", "app_debug"})
public abstract interface RoomDao {
    
    @androidx.room.Insert()
    public abstract void addToFavorite(@org.jetbrains.annotations.NotNull()
    com.foodrunner.model.FavoriteModel restaurant);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM FavoriteModel")
    public abstract java.util.List<com.foodrunner.model.FavoriteModel> getFavoriteRestaurantList();
    
    @androidx.room.Delete()
    public abstract void removeFromFav(@org.jetbrains.annotations.NotNull()
    com.foodrunner.model.FavoriteModel restaurant);
    
    @androidx.room.Insert()
    public abstract void addToCart(@org.jetbrains.annotations.NotNull()
    com.foodrunner.model.MenuModelResponse.Data.MenuData food);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM MenuData")
    public abstract java.util.List<com.foodrunner.model.MenuModelResponse.Data.MenuData> getCart();
    
    @androidx.room.Delete()
    public abstract void removeFromCart(@org.jetbrains.annotations.NotNull()
    com.foodrunner.model.MenuModelResponse.Data.MenuData food);
    
    @androidx.room.Query(value = "DELETE FROM MenuData")
    public abstract void clearCart();
}