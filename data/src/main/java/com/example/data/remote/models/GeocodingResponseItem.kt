package com.example.data.remote.models

import com.squareup.moshi.Json

data class GeocodingResponseItem(
    @Json(name = "name") val name: String,
    @Json(name = "lat") val latitude: Double,
    @Json(name = "lon") val longitude: Double,
    @Json(name = "country") val country: String,
    @Json(name = "state") val state: String? = null
)
