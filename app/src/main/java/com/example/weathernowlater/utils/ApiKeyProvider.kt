package com.example.weathernowlater.utils

object ApiKeyProvider {
    init {
        System.loadLibrary("native-lib")
    }

    external fun getApiKey(): String
}