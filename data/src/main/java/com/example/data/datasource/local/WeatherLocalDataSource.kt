package com.example.data.datasource.local

import com.example.data.local.models.RecentCityEntity
import kotlinx.coroutines.flow.Flow

interface WeatherLocalDataSource {

    suspend fun saveRecentCity(city: RecentCityEntity)

    fun getRecentCities(): Flow<List<RecentCityEntity>>
}
