package com.arash.altafi.weatherapp4.weather_api

class WeatherApiException(
    message: String,
    e: Throwable? = null
) : Exception(
    message,
    e
)
