package com.example.data.remote

import com.squareup.moshi.Json

data class ForecastResponse(
    @Json(name = "list") val forecastList: List<WeatherData>,
    @Json(name = "city") val city: City
)

data class WeatherData(
    @Json(name = "dt") val timestamp: Long,
    @Json(name = "main") val main: MainWeather,
    @Json(name = "weather") val weather: List<WeatherDescription>,
    @Json(name = "wind") val wind: Wind,
    @Json(name = "dt_txt") val dateText: String
)

data class MainWeather(
    @Json(name = "temp") val temp: Double,
    @Json(name = "feels_like") val feelsLike: Double,
    @Json(name = "temp_min") val tempMin: Double,
    @Json(name = "temp_max") val tempMax: Double,
    @Json(name = "pressure") val pressure: Int,
    @Json(name = "humidity") val humidity: Int
)

data class WeatherDescription(
    @Json(name = "id") val id: Int,
    @Json(name = "main") val main: String,
    @Json(name = "description") val description: String,
    @Json(name = "icon") val icon: String
)

data class Wind(
    @Json(name = "speed") val speed: Double,
    @Json(name = "deg") val degree: Int
)

data class City(
    @Json(name = "name") val name: String,
    @Json(name = "country") val country: String
)

