package com.arash.altafi.weatherapp4.weather_repository

import android.content.Context
import android.content.SharedPreferences
import com.arash.altafi.weatherapp4.graph.WeatherGraph

class WeatherRepositoryModule {

    fun createWeatherRepository(): WeatherRepository {
        return WeatherRepositoryImpl(
            createSharedPreferences()
        )
    }

    private fun createSharedPreferences(): SharedPreferences {
        val context = WeatherGraph.getContext()
        return context.getSharedPreferences(
            WeatherRepositoryImpl.PREFERENCE_NAME,
            Context.MODE_PRIVATE
        )
    }
}
