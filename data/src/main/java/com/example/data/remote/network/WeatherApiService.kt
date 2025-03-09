package com.example.data.remote.network

import com.example.core.constants.EndPointsNamesConstants.GEO_CODING_ENDPOINT
import com.example.core.constants.EndPointsNamesConstants.WEATHER_FORECAST_ENDPOINT
import com.example.core.constants.EndPointsParametersNamesConstants.APP_ID
import com.example.core.constants.EndPointsParametersNamesConstants.CITY_COUNT_LIMIT
import com.example.core.constants.EndPointsParametersNamesConstants.CITY_NAME
import com.example.core.constants.EndPointsParametersNamesConstants.LATITUDE
import com.example.core.constants.EndPointsParametersNamesConstants.LONGITUDE
import com.example.core.constants.EndPointsParametersNamesConstants.LIMIT
import com.example.core.constants.EndPointsParametersNamesConstants.METRIC
import com.example.core.constants.EndPointsParametersNamesConstants.UNITS
import com.example.data.remote.models.ForecastResponse
import com.example.data.remote.models.GeocodingResponseItem
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {

    @GET(GEO_CODING_ENDPOINT)
    suspend fun getCityCoordinates(
        @Query(CITY_NAME) cityName: String,
        @Query(LIMIT) limit: Int = CITY_COUNT_LIMIT,
        @Query(APP_ID) apiKey: String
    ): List<GeocodingResponseItem>

    @GET(WEATHER_FORECAST_ENDPOINT)
    suspend fun getWeatherForecast(
        @Query(LATITUDE) lat: Double,
        @Query(LONGITUDE) lon: Double,
        @Query(APP_ID) apiKey: String,
        @Query(UNITS) units: String = METRIC
    ): ForecastResponse
}