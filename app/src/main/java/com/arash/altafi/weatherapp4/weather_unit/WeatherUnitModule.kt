package com.arash.altafi.weatherapp4.weather_unit

import android.content.Context
import android.content.SharedPreferences
import com.arash.altafi.weatherapp4.graph.WeatherGraph

class WeatherUnitModule {

    fun createWeatherUnitManager(): WeatherUnitManager {
        return WeatherUnitManagerImpl(
            createSharedPreferences()
        )
    }

    private fun createSharedPreferences(): SharedPreferences {
        val context = WeatherGraph.getContext()
        return context.getSharedPreferences(
            WeatherUnitManagerImpl.PREFERENCE_NAME,
            Context.MODE_PRIVATE
        )
    }
}
