package com.example.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.local.models.RecentCityEntity

@Database(entities = [RecentCityEntity::class], version = 1, exportSchema = false)
abstract class WeatherDatabase : RoomDatabase() {
    abstract fun recentCityDao(): RecentCityDao
}