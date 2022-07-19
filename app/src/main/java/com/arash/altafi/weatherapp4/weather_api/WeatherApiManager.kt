package com.arash.altafi.weatherapp4.weather_api

import androidx.annotation.IntRange
import androidx.annotation.WorkerThread
import com.arash.altafi.weatherapp4.weather.Weather
import com.arash.altafi.weatherapp4.weather_unit.WeatherUnit

interface WeatherApiManager {

    /**
     * @throws WeatherApiException
     */
    @WorkerThread
    fun getWeather(
        city: String,
        weatherUnit: WeatherUnit
    ): Weather

    /**
     * @throws WeatherApiException
     */
    @WorkerThread
    fun getWeatherForecastDaily(
        city: String,
        weatherUnit: WeatherUnit,
        @IntRange(from = 1, to = 16)
        numberOfDays: Int
    ): List<Weather>
}
