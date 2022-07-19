package com.arash.altafi.weatherapp4.weather_repository

import com.arash.altafi.weatherapp4.weather.Weather

interface WeatherRepository {

    fun getWeather(): Weather?

    fun setWeather(weather: Weather?)

    fun getWeatherForecastDaily(): List<Weather>

    fun setWeatherForecastDaily(weathers: List<Weather>)

    fun addListener(listener: Listener)

    fun removeListener(listener: Listener)

    interface Listener {

        fun onChanged()
    }
}
