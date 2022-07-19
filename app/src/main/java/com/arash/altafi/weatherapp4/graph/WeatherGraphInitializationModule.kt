package com.arash.altafi.weatherapp4.graph

class WeatherGraphInitializationModule {

    fun createWeatherGraphInitializationManager(): WeatherGraphInitializationManager {
        return WeatherGraphInitializationManagerImpl(
            WeatherGraph.getCityManager(),
            WeatherGraph.getWeatherManager(),
            WeatherGraph.getWeatherUnitManager()
        )
    }
}
