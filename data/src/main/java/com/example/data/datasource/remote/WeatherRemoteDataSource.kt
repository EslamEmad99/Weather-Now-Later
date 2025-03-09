package com.example.data.datasource.remote

import com.example.data.remote.models.ForecastResponse
import com.example.data.remote.models.GeocodingResponseItem

interface WeatherRemoteDataSource {
    suspend fun getCityCoordinates(cityName: String): List<GeocodingResponseItem>
    suspend fun getWeatherForecast(lat: Double, lon: Double): ForecastResponse
}