package com.foodrunner.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.foodrunner.model.FavoriteModel
import com.foodrunner.model.RestaurantDetailsResponse

@Database(entities = [FavoriteModel::class, RestaurantDetailsResponse.Data.MenuData::class], version = 5, exportSchema = false)

abstract class AppDatabase : RoomDatabase() {

    abstract fun RoomDao(): RoomDao
    companion object {
        private var INSTANCE: AppDatabase? = null
        private val sLock = Any()
        fun getInstance(context: Context): AppDatabase {
            synchronized(sLock) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        AppDatabase::class.java, "FoodRunner_db")
                        .fallbackToDestructiveMigration()
                        .build()
                }
                return INSTANCE as AppDatabase
            }
        }
    }
}