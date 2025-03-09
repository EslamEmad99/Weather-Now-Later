package com.example.data.datasource.local

import com.example.data.local.models.RecentCityEntity
import com.example.data.local.room.RecentCityDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WeatherLocalDataSourceImpl @Inject constructor(
    private val recentCityDao: RecentCityDao
) : WeatherLocalDataSource {

    override suspend fun saveRecentCity(city: RecentCityEntity) {
        recentCityDao.insertCity(city)
    }

    override fun getRecentCities(): Flow<List<RecentCityEntity>> {
        return recentCityDao.getRecentCities()
    }
}