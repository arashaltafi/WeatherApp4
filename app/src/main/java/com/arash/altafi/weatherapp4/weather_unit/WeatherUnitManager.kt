package com.arash.altafi.weatherapp4.weather_unit

interface WeatherUnitManager {

    fun getWeatherUnit(): WeatherUnit

    fun setWeatherUnit(weatherUnit: WeatherUnit)

    fun addListener(listener: Listener)

    fun removeListener(listener: Listener)

    interface Listener {

        fun onChanged()
    }
}
