package com.example.core.utils

object ApiKeyProvider {
    init {
        System.loadLibrary("native-lib")
    }

    external fun getApiKey(): String
}