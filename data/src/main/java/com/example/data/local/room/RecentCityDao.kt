package com.example.data.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.local.models.RecentCityEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RecentCityDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCity(city: RecentCityEntity)

    @Query("SELECT * FROM recent_cities ORDER BY id DESC LIMIT 5")
    fun getRecentCities(): Flow<List<RecentCityEntity>>
}