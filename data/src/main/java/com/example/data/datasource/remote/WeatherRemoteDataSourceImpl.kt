package com.example.data.datasource.remote

import com.example.core.di.ApiKey
import com.example.data.remote.ForecastResponse
import com.example.data.remote.GeocodingResponseItem
import com.example.data.remote.WeatherApiService
import javax.inject.Inject

class WeatherRemoteDataSourceImpl @Inject constructor(
    private val weatherApiService: WeatherApiService,
    @ApiKey private val apiKey: String
) : WeatherRemoteDataSource {

    override suspend fun getCityCoordinates(cityName: String): List<GeocodingResponseItem> {
        return weatherApiService.getCityCoordinates(cityName = cityName, apiKey = apiKey)
    }

    override suspend fun getWeatherForecast(lat: Double, lon: Double): ForecastResponse {
        return weatherApiService.getWeatherForecast(lat = lat, lon = lon, apiKey = apiKey)
    }
}