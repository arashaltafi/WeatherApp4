package com.arash.altafi.weatherapp4.weather_api

import com.arash.altafi.weatherapp4.graph.WeatherGraph

class WeatherApiModule {

    fun createWeatherApiManager(): WeatherApiManager {
        return WeatherApiManagerImpl(
            WeatherGraph.getNetworkManager()
        )
    }
}
