package com.arash.altafi.weatherapp4.graph

import com.arash.altafi.weatherapp4.weather.WeatherManager
import com.arash.altafi.weatherapp4.weather_unit.WeatherUnitManager

class WeatherGraphInitializationManagerImpl(
    private val cityManager: com.arash.altafi.weatherapp4.city.CityManager,
    private val weatherManager: WeatherManager,
    private val weatherUnitManager: WeatherUnitManager
) : WeatherGraphInitializationManager {

    override fun initialize() {
        cityManager.addListener(createCityListener())
        weatherUnitManager.addListener(createWeatherUnitListener())
    }

    private fun createCityListener() = object : com.arash.altafi.weatherapp4.city.CityManager.Listener {
        override fun onChanged() {
            weatherManager.clearCache()
            weatherManager.load()
        }
    }

    private fun createWeatherUnitListener() = object : WeatherUnitManager.Listener {
        override fun onChanged() {
            weatherManager.clearCache()
            weatherManager.load()
        }
    }
}
