package com.example.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.core.constants.LocalDataStorageConstants.RECENT_CITIES_TABLE_NAME

@Entity(tableName = RECENT_CITIES_TABLE_NAME)
data class RecentCityEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val cityName: String,
    val latitude: Double,
    val longitude: Double
)
